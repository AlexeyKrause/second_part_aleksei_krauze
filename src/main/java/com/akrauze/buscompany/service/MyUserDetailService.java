package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.model.MyUserDetail;
import com.akrauze.buscompany.model.User;
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

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Optional<User> user = userDao.
        return new MyUserDetail(login);
    }
}
