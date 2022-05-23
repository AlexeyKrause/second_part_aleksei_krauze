package com.akrauze.buscompany.service;

import com.akrauze.buscompany.config.MyUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new MyUserDetail(login);
    }
}
