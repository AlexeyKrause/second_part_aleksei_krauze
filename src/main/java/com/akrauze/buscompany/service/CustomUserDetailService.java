//package com.akrauze.buscompany.service;
//
//import com.akrauze.buscompany.dao.UserDao;
//import com.akrauze.buscompany.exception.ErrorCode;
//import com.akrauze.buscompany.exception.ServerException;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    UserDao userDao;
//
//    @SneakyThrows
//    @Override
//    public UserDetails loadUserByUsername(String login) {
//        Optional.ofNullable(userDao.getIdByLogin(login)).orElseThrow(
//                () -> new ServerException("404", "login", ErrorCode.THE_USER_NOT_FOUND));
//        UserDetails user = org.springframework.security.core.userdetails.User.builder()
//                .username(login)
//                .password(userDao.getPassByLogin(login))
//                .roles(userDao.getUserRoleByLogin(login))
//                .build();
//        return user;
//    }
//}
