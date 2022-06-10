package com.akrauze.buscompany.config;

import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.MyException;
import com.akrauze.buscompany.model.MyUserDetail;
import com.akrauze.buscompany.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;


//@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserDao userDao;

    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ApplicationProperties applicationProperties = new ApplicationProperties();

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN"))
        {
            request.getSession().setMaxInactiveInterval(10);
        }
        else
        {
            request.getSession().setMaxInactiveInterval(10);
        }
        MyUserDetail userDetails = (MyUserDetail) authentication.getPrincipal();
        User user = Optional.ofNullable(userDao.getUserByLogin(userDetails.getPassword())).orElseThrow(
                () -> new MyException(ErrorCode.THE_USER_NOT_FOUND));
        MyUserDetail myUserDetail = new MyUserDetail(user);
        response.sendRedirect(request.getContextPath());
    }
}
