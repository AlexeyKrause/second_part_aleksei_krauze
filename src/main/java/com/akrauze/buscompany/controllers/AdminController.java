package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.AdminDtoRequest;
import com.akrauze.buscompany.dtorequest.CredentialsSessionDtoRequest;
import com.akrauze.buscompany.dtoresponse.AdminDtoResponse;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.AdminService;
import com.akrauze.buscompany.service.SessionService;
import com.akrauze.buscompany.service.ValidateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;
    private final SessionService sessionService;
    public final ValidateService validateService;

    public AdminController(AdminService adminService, SessionService sessionService, ValidateService validateService) {
        this.adminService = adminService;
        this.sessionService = sessionService;
        this.validateService = validateService;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse getAdmin(@PathVariable("id") int id) {
        return adminService.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDtoResponse postAdmin(@Valid @RequestBody AdminDtoRequest adminDtoRequest, HttpServletResponse httpServletResponse) throws ServerException {
        validateService.checkNewLogin(adminDtoRequest.getLogin());
        adminService.postAdmin(adminDtoRequest);
        return sessionService.login(new CredentialsSessionDtoRequest(adminDtoRequest.getLogin(), adminDtoRequest.getPassword()), httpServletResponse);
    }
}
