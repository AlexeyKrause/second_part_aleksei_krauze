package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.AdminService;
import com.akrauze.buscompany.service.ClientService;
import com.akrauze.buscompany.service.SessionService;
import com.akrauze.buscompany.service.ValidateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final SessionService sessionService;
    private final AdminService adminService;
    private final ClientService clientService;
    private final UserDaoImpl userDao;
    private final ValidateService validateService;

    public AccountController(SessionService sessionService, AdminService adminService, ClientService clientService, UserDaoImpl userDao, ValidateService validateService) {
        this.sessionService = sessionService;
        this.adminService = adminService;
        this.clientService = clientService;
        this.userDao = userDao;
        this.validateService = validateService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDtoResponse getUserResponse(HttpServletRequest httpServletRequest) throws ServerException {
        if (validateService.checkUserRole(httpServletRequest, "ADMIN"))
            return adminService.getByJavaSessionId(sessionService.getJavaSession(httpServletRequest).getJavaSessionId());
        else
            return clientService.getClientByJavaSessionId(sessionService.getJavaSession(httpServletRequest).getJavaSessionId());
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAccount(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return sessionService.deleteAccount(httpServletRequest, httpServletResponse);
    }
}
