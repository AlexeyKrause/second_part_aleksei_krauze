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
        } else if(userDao.getUserRoleByLogin(login).equals("ADMIN"))
            return adminMapper.modelToDtoResponse(adminDao.getByLogin(login));
        else return null;//на случай если будут еще роли
    }

    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Session session = getJavaSessionId(httpServletRequest, httpServletResponse);
        session.setActive(false);
        session.setJavaSessionId(null);
        sessionDao.updateSession(session);
    }

    public Session getJavaSessionId(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<Cookie> cookies = Arrays.stream(httpServletRequest.getCookies()).filter(p -> p.getName().equals("JAVASESSIONID") ).collect(Collectors.toList());
        httpServletResponse.addCookie(new Cookie("JAVASESSIONID", ""));
        return sessionDao.getByJavaSessionId(cookies.get(0).getValue());
    }
}
