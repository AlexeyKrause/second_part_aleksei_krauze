package com.akrauze.buscompany.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

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
        //Your login success url goes here, currently login success url="/"
        response.sendRedirect(request.getContextPath());
    }
}
