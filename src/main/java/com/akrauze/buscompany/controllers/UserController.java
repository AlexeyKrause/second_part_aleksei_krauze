package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.dtoRequest.UserDtoRequest;
import com.akrauze.buscompany.dtoResponse.UserDtoResponse;
import com.akrauze.buscompany.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private final UserDao userDao;
    @Autowired
    private final UserMapper userMapper;


    public UserController(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "users/{id}",produces =  MediaType.APPLICATION_JSON_VALUE)
    public UserDtoResponse getUserById(@PathVariable("id") int id) {
        return userMapper.modelToDtoResponse(userDao.getUserById(id));
    }

    @PostMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDtoResponse postUser(@Valid @RequestBody UserDtoRequest userDtoRequest) {
        return userMapper.modelToDtoResponse(userDao.insert(userMapper.dtoToModel(userDtoRequest)));
    }

    @GetMapping(value = "/client")
    public String getClientPage(Principal principal) {
        return "Welcome to the Client Page for - " + principal.getName();
    }

    @GetMapping(value = "/home")
    public String getHomePage(Principal principal) {
        return "Welcome to the Home Page for - " + principal.getName();
    }
}
