package com.akrauze.buscompany.config;

import com.akrauze.buscompany.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
//    MyUserDetailService myUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/users").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "CLIENT")
                .and().httpBasic();

        http.csrf().disable();

        http.logout(logout ->
                logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies()
        );
    }

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return myUserDetailService;
//    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(13);
        return NoOpPasswordEncoder.getInstance();
    }
}
