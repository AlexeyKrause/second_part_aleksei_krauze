package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.ClientDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.ClientDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.mappers.ClientMapper;
import com.akrauze.buscompany.model.Client;
import com.akrauze.buscompany.model.Session;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final UserDaoImpl userDao;
    private final ClientDaoImpl clientDao;
    private final SessionDaoImpl sessionDao;
    private final ClientMapper clientMapper;

    public ClientService(UserDaoImpl userDao, ClientDaoImpl clientDao, SessionDaoImpl sessionDao, ClientMapper clientMapper) {
        this.userDao = userDao;
        this.clientDao = clientDao;
        this.sessionDao = sessionDao;
        this.clientMapper = clientMapper;
    }


    public ClientDtoResponse getClientById(int id) {
        return clientMapper.modelToDtoResponse(clientDao.getById(id));
    }

    public ClientDtoResponse potClient(ClientDtoRequest clientDtoRequest) {
        Client client = clientMapper.dtoToModel(clientDtoRequest);
        userDao.insertFromClient(client);
        int userId = userDao.getIdByLogin(client.getLogin());
        sessionDao.insert(new Session(userId));
        return clientMapper.modelToDtoResponse(clientDao.insert(client, userId));
    }
}
