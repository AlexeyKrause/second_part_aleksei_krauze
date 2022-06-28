package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.AdminDaoImpl;
import com.akrauze.buscompany.daoimpl.ClientDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.SessionDtoRequest;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.mappers.AdminMapper;
import com.akrauze.buscompany.mappers.ClientMapper;
import com.akrauze.buscompany.model.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SessionService {
    private final SessionDaoImpl sessionDao;
    private final UserDaoImpl userDao;
    private final AdminDaoImpl adminDao;
    private final ClientDaoImpl clientDao;
    private final AdminMapper adminMapper;
    private final ClientMapper clientMapper;

    public SessionService(UserDaoImpl userDao, SessionDaoImpl sessionDao, ClientDaoImpl clientDao, AdminMapper adminMapper,
                          AdminDaoImpl adminDao, ClientMapper clientMapper) {
        this.userDao = userDao;
        this.sessionDao = sessionDao;
        this.clientDao = clientDao;
        this.adminMapper = adminMapper;
        this.adminDao = adminDao;
        this.clientMapper = clientMapper;
    }

    public UserDtoResponse login(SessionDtoRequest sessionDtoRequest, HttpServletResponse httpServletResponse) throws ServerException {
        String login = sessionDtoRequest.getLogin();
        Optional.ofNullable(userDao.getIdByLogin(login)).orElseThrow(
                () -> new ServerException(ErrorCode.THE_USER_NOT_FOUND.toString(), "login", "Данный логин не существует"));
        Optional.ofNullable(userDao.getPassByLogin(login)).orElseThrow(
                () -> new ServerException(ErrorCode.PASSWORD_NOT_CORRECT.toString(), "password", "Не верный пароль"));
        /* добавление статуса активности и новой куки JAVASESSIONID----------------------------------------------------------------------------*/
        String javaSessionId = UUID.randomUUID().toString();
        sessionDao.updateSession(new Session(userDao.getIdByLogin(login), true, javaSessionId));
        httpServletResponse.addCookie(new Cookie("JAVASESSIONID", javaSessionId));
        if (userDao.getUserRoleByLogin(login).equals("CLIENT")) {
            return clientMapper.modelToDtoResponse(clientDao.getByLogin(sessionDtoRequest.getLogin()));
        } else
            return adminMapper.modelToDtoResponse(adminDao.getByLogin(sessionDtoRequest.getLogin()));
    }

    public String logout(HttpServletRequest httpServletRequest) {
        return Arrays.toString(httpServletRequest.getCookies());
    }
}
