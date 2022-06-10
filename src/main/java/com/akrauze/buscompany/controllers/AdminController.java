package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoImpl.AdminDao;
import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.dtoRequest.AdminDtoRequest;
import com.akrauze.buscompany.dtoResponse.AdminDtoResponse;
import com.akrauze.buscompany.mappers.AdminMapper;
import com.akrauze.buscompany.mappers.UserMapper;
import com.akrauze.buscompany.model.Admin;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminDao adminDao;
    private final UserDao userDao;
    private final AdminMapper adminMapper;
    private final UserMapper userMapper;

    public AdminController(AdminDao adminDao, UserDao userDao, AdminMapper adminMapper, UserMapper userMapper) {
        this.adminDao = adminDao;
        this.userDao = userDao;
        this.adminMapper = adminMapper;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse getAdmin(@PathVariable("id") int id) {
        return adminMapper.modelToDtoResponse(adminDao.getAdminById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse postAdmin(@Valid @RequestBody AdminDtoRequest adminDtoRequest) {
        Admin admin = adminMapper.dtoToModel(adminDtoRequest);
        userDao.insert(userDao.insert(admin.getUser()));
        return adminMapper.modelToDtoResponse(adminDao.insert(admin));
    }
}
