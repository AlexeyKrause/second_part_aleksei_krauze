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
    // REVU нет, так не годится
    // контроллер должен вызывать метод сервиса, а тот - DAO
    // и проверять, кстати. А если такого id нет ?
    // Надо выбросить ServerException, поймать его и вернуть json с error
    // а у Вас просто null получится
    // И не должен метод возвращать класс модели User
    // а должен возвращать UserInfoDto (или AdminInfoDto, ClientInfoDto и т.д.)
    // и вообще - какому пункту ТЗ этот метод соответствует ?
    // нет такого пункта - получить информацию о любом юзере по id
    public User getUserById(@PathVariable("id") int id) {
        return userDao.getById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    // REVU нет такого в ТЗ - добавить User
    // нет и не может быть
    // может быть регистрация админа или клиента
    // с автоматическим логином, кстати - см. ТЗ
    // и делать это должен сервис, метод которого тут надо вызвать
    // а он уж будет вызывать один или несколько методов DAO и осуществлять все остальные действия
    public User postUser(@Valid @RequestBody UserDtoRequest userDtoRequest) {
        return userDao.insert(userMapper.dtoToModel(userDtoRequest));
    }
}
