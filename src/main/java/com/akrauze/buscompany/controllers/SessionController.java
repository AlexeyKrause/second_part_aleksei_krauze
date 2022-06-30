package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.CredentialsSessionDtoRequest;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.SessionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDtoResponse postLogin(@Valid @RequestBody CredentialsSessionDtoRequest sessionDtoRequest,
                                     HttpServletResponse httpServletResponse) throws ServerException {
        return sessionService.login(sessionDtoRequest, httpServletResponse);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public void logout(HttpServletRequest httpServletRequest) {
        sessionService.logout(httpServletRequest);
    }
}
