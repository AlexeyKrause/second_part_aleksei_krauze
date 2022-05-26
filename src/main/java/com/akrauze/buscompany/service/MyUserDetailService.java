package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.MyException;
import com.akrauze.buscompany.model.MyUserDetail;
import com.akrauze.buscompany.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = Optional.ofNullable(userDao.getUserByLogin(login)).orElseThrow(
                () -> new MyException(ErrorCode.THE_USER_NOT_FOUND));
        return new MyUserDetail(user);
    }
}
