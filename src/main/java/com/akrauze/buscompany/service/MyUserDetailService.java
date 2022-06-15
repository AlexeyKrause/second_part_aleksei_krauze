package com.akrauze.buscompany.service;

import com.akrauze.buscompany.dao.UserDao;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String login) {
        User myUser = Optional.ofNullable(userDao.getUserByLogin(login)).orElseThrow(
                () -> new ServerException(ErrorCode.THE_USER_NOT_FOUND));
        UserDetails user = org.springframework.security.core.userdetails.User.builder()
                .username(myUser.getLogin())
                .password(myUser.getPassword())
                .roles(myUser.getUserRole().toString())
                .build();
        return user;
    }
}
