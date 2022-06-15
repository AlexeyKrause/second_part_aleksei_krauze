package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoimpl.AdminDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.AdminDtoRequest;
import com.akrauze.buscompany.dtoresponse.AdminDtoResponse;
import com.akrauze.buscompany.mappers.AdminMapper;
import com.akrauze.buscompany.mappers.UserMapper;
import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.Session;
import com.akrauze.buscompany.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminDaoImpl adminDao;
    private final UserDaoImpl userDao;
    private final SessionDaoImpl sessionDao;
    private final AdminMapper adminMapper;
    private final UserMapper userMapper;

    public AdminController(AdminDaoImpl adminDao, UserDaoImpl userDao, SessionDaoImpl sessionDao, AdminMapper adminMapper, UserMapper userMapper) {
        this.adminDao = adminDao;
        this.userDao = userDao;
        this.sessionDao = sessionDao;
        this.adminMapper = adminMapper;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse getAdmin(@PathVariable("id") int id) {
        return adminMapper.modelToDtoResponse(adminDao.getById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminDtoResponse postAdmin(@Valid @RequestBody AdminDtoRequest adminDtoRequest) {
        User user = userDao.insert(userMapper.dtoToModel(userMapper.adminDtoToUserDto(adminDtoRequest)));
        Admin admin = adminMapper.dtoToModel(adminDtoRequest);
        sessionDao.insert(new Session(user.getId()));
        return adminMapper.modelToDtoResponse(adminDao.insert(admin, user));
    }
}
