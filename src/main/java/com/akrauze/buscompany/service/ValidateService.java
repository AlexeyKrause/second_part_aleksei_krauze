package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.AdminDaoImpl;
import com.akrauze.buscompany.daoimpl.ClientDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.CredentialsSessionDtoRequest;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.ServerException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class ValidateService {
    public final AdminDaoImpl adminDao;
    public final ClientDaoImpl clientDao;
    public final UserDaoImpl userDao;
    public final SessionDaoImpl sessionDao;
    public final SessionService sessionService;

    public ValidateService(AdminDaoImpl adminDao, ClientDaoImpl clientDao, UserDaoImpl userDao, SessionDaoImpl sessionDao, SessionService sessionService) {
        this.adminDao = adminDao;
        this.clientDao = clientDao;
        this.userDao = userDao;
        this.sessionDao = sessionDao;
        this.sessionService = sessionService;
    }

    public void checkLoginCredential(CredentialsSessionDtoRequest credentials) throws ServerException {
        Optional.ofNullable(userDao.getIdByLogin(credentials.getLogin())).orElseThrow(
                () -> new ServerException(ErrorCode.LOGIN_NOT_FOUND, "login"));
        Optional.ofNullable(userDao.getPassByLogin(credentials.getLogin())).orElseThrow(
                () -> new ServerException(ErrorCode.EMPTY_PASSWORD, "password"));
        checkPasswordByLogin(credentials.getPassword(), credentials.getLogin());
    }

    public void checkNewLogin(String login) throws ServerException {
        if (userDao.getCountLogin(login) >= 1) {
            throw new ServerException(ErrorCode.LOGIN_ALREADY_EXIST, "login");
        }
    }

    public void checkPasswordByLogin(String password, String login) throws ServerException {
        if (!password.equals(userDao.getPassByLogin(login)))
            throw new ServerException(ErrorCode.INVALID_PASSWORD, "password");
    }

    public boolean checkUserRole(HttpServletRequest httpServletRequest, String role) throws ServerException {
        if (!sessionService.getJavaSession(httpServletRequest).getJavaSessionId().equals(role))
            throw new ServerException(ErrorCode.YOU_DONT_HAVE_PERMISSION, "userRole");
        else
            return true;

    }
}
