package com.akrauze.buscompany.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableAutoConfiguration
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
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/users").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "CLIENT")
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .antMatchers("/api/users").permitAll()
                .and().httpBasic()
                .and().authorizeRequests();


        http.logout(logout ->
                logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies()
        );
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Bean
    protected PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(13);
        return NoOpPasswordEncoder.getInstance();
    }
}
