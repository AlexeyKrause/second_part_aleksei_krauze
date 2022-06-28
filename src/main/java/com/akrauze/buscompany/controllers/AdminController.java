package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.AdminDtoRequest;
import com.akrauze.buscompany.dtorequest.SessionDtoRequest;
import com.akrauze.buscompany.dtoresponse.AdminDtoResponse;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.AdminService;
import com.akrauze.buscompany.service.SessionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;
    private final SessionService sessionService;

    public AdminController(AdminService adminService, SessionService sessionService) {
        this.adminService = adminService;
        this.sessionService = sessionService;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse getAdmin(@PathVariable("id") int id) {
        return adminService.getAdminById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDtoResponse postAdmin(@Valid @RequestBody AdminDtoRequest adminDtoRequest, HttpServletResponse httpServletResponse) throws ServerException {
        adminService.postAdmin(adminDtoRequest);
        return sessionService.login(new SessionDtoRequest(adminDtoRequest.getLogin(), adminDtoRequest.getPassword()), httpServletResponse);
    }
}
