package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.AdminDaoImpl;
import com.akrauze.buscompany.daoimpl.ClientDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.CredentialsSessionDtoRequest;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.mappers.AdminMapper;
import com.akrauze.buscompany.mappers.ClientMapper;
import com.akrauze.buscompany.model.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class SessionService {
    private final SessionDaoImpl sessionDao;
    private final UserDaoImpl userDao;
    private final AdminDaoImpl adminDao;
    private final ClientDaoImpl clientDao;
    private final AdminMapper adminMapper;
    private final ClientMapper clientMapper;
    private final ValidateService validateService;

    public SessionService(UserDaoImpl userDao, SessionDaoImpl sessionDao, ClientDaoImpl clientDao, AdminMapper adminMapper,
                          AdminDaoImpl adminDao, ClientMapper clientMapper, ValidateService validateService) {
        this.userDao = userDao;
        this.sessionDao = sessionDao;
        this.clientDao = clientDao;
        this.adminMapper = adminMapper;
        this.adminDao = adminDao;
        this.clientMapper = clientMapper;
        this.validateService = validateService;
    }

    public UserDtoResponse login(CredentialsSessionDtoRequest credentials, HttpServletResponse httpServletResponse) throws ServerException {
        validateService.checkLoginCredential(credentials);
        String login = credentials.getLogin();
        /* добавление статуса активности и новой куки JAVASESSIONID----------------------------------------------------------------------------*/
        String javaSessionId = UUID.randomUUID().toString();
        sessionDao.updateSession(new Session(userDao.getIdByLogin(login), true, javaSessionId));
        httpServletResponse.addCookie(new Cookie("JAVASESSIONID", javaSessionId));
        if (userDao.getUserRoleByLogin(login).equals("CLIENT")) {
            return clientMapper.modelToDtoResponse(clientDao.getByLogin(login));
        } else
            return adminMapper.modelToDtoResponse(adminDao.getByLogin(login));
    }

    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Session session = getJavaSession(httpServletRequest);
        session.setJavaSessionId(null);
        sessionDao.updateSession(session);
        httpServletResponse.addCookie(new Cookie("JAVASESSIONID", ""));
        return "";
    }

    public String deleteAccount(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Session session = getJavaSession(httpServletRequest);
        session.setActive(false);
        session.setJavaSessionId(null);
        sessionDao.updateSession(session);
        httpServletResponse.addCookie(new Cookie("JAVASESSIONID", ""));
        return "";
    }

    public Session getJavaSession(HttpServletRequest httpServletRequest) {
        List<Cookie> cookies = Arrays.stream(httpServletRequest.getCookies()).filter(p
                -> p.getName().equals("JAVASESSIONID") ).collect(Collectors.toList());
        return sessionDao.getByJavaSessionId(cookies.get(0).getValue());
    }


}
