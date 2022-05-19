package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/{id}",produces =  MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") int id) {
        return userDao.getUser(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User postUser(@Valid @RequestBody User user) {
        return userDao.insert(user);
    }
}
