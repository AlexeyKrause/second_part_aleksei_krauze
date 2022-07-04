package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public String getUserRoleByJavaSessionId(String javaSessionId) {
        return userDao.getUserRoleByJavaSessionId(javaSessionId);
    }
}
