package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.daoimpl.ClientDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.ClientDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.mappers.ClientMapper;
import com.akrauze.buscompany.mappers.UserMapper;
import com.akrauze.buscompany.model.Client;
import com.akrauze.buscompany.model.Session;
import com.akrauze.buscompany.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final UserDaoImpl userDao;
    private final ClientDaoImpl clientDao;
    private final SessionDaoImpl sessionDao;
    private final ClientMapper clientMapper;
    private final UserMapper userMapper;

    public ClientController(UserDaoImpl userDao, ClientDaoImpl clientDao, SessionDaoImpl sessionDao, ClientMapper clientMapper, UserMapper userMapper) {
        this.userDao = userDao;
        this.clientDao = clientDao;
        this.sessionDao = sessionDao;
        this.clientMapper = clientMapper;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDtoResponse getById(@PathVariable("id") int id) {
        return clientMapper.modelToDtoResponse(clientDao.getById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDtoResponse postClient(@Valid @RequestBody ClientDtoRequest clientDtoRequest) {
        User user = userDao.insert(userMapper.clientDtoToUserDto(clientDtoRequest));
        Client client = clientMapper.dtoToModel(clientDtoRequest);
        sessionDao.insert(new Session(user.getId()));
        return clientMapper.modelToDtoResponse(clientDao.insert(client, user));
    }
}
