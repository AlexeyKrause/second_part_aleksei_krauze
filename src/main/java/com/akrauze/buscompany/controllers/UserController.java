package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "users/{id}",produces =  MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") int id) {
        return userDao.getUserById(id);
    }

    @PostMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User postUser(@Valid @RequestBody User user) {
        return userDao.insert(user);
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
