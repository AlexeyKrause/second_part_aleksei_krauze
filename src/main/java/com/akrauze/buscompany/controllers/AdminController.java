package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoImpl.AdminDao;
import com.akrauze.buscompany.daoImpl.UserDao;
import com.akrauze.buscompany.model.Admin;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminDao adminDao;
    private final UserDao userDao;

    public AdminController(AdminDao adminDao, UserDao userDao) {
        this.adminDao = adminDao;
        this.userDao = userDao;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Admin getAdmin(@PathVariable("id") int id) {
        return adminDao.getAdminById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Admin postAdmin(@Valid @RequestBody Admin admin) {
        userDao.insert(admin.getUser());
        adminDao.insert(admin);
        return admin;
    }
}
