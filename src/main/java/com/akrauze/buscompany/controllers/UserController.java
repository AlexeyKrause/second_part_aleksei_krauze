package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.UserDtoRequest;
import com.akrauze.buscompany.mappers.UserMapper;
import com.akrauze.buscompany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private final UserDaoImpl userDao;
    @Autowired
    private final UserMapper userMapper;


    public UserController(UserDaoImpl userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/{id}",produces =  MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") int id) {
        return userDao.getById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User postUser(@Valid @RequestBody UserDtoRequest userDtoRequest) {
        return userDao.insert(userMapper.dtoToModel(userDtoRequest));
    }
}
