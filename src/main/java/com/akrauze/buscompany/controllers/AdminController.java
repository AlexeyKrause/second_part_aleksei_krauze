package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.AdminDtoRequest;
import com.akrauze.buscompany.dtoresponse.AdminDtoResponse;
import com.akrauze.buscompany.service.AdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse getAdmin(@PathVariable("id") int id) {
        return adminService.getAdminById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse postAdmin(@Valid @RequestBody AdminDtoRequest adminDtoRequest) {
        return adminService.postAdmin(adminDtoRequest);
    }
}
