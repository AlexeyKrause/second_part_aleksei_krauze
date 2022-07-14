package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.ClientDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.CreateClientDtoRequest;
import com.akrauze.buscompany.dtorequest.UpdateClientDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.dtoresponse.UpdateClientDtoResponse;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.mappers.ClientMapper;
import com.akrauze.buscompany.model.Client;
import com.akrauze.buscompany.model.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientService {
    private final UserDaoImpl userDao;
    private final ClientDaoImpl clientDao;
    private final SessionDaoImpl sessionDao;
    private final ClientMapper clientMapper;
    private final SessionService sessionService;
    private final ValidateService validateService;


    public ClientService(UserDaoImpl userDao, ClientDaoImpl clientDao, SessionDaoImpl sessionDao,
                         ClientMapper clientMapper, SessionService sessionService, ValidateService validateService) {
        this.userDao = userDao;
        this.clientDao = clientDao;
        this.sessionDao = sessionDao;
        this.clientMapper = clientMapper;
        this.sessionService = sessionService;
        this.validateService = validateService;
    }

    public List<ClientDtoResponse> getAllClient(HttpServletRequest httpServletRequest) throws ServerException {
        validateService.checkUserRole(httpServletRequest, "ADMIN");
        return clientDao.getAll().stream().map(clientMapper::modelToDtoResponse).collect(Collectors.toList());
    }

    public ClientDtoResponse getClientById(int id) {
        return clientMapper.modelToDtoResponse(clientDao.getById(id));
    }

    public ClientDtoResponse getClientByJavaSessionId(String javaSessionId) {
        return clientMapper.modelToDtoResponse(clientDao.getByJavaSessionId(javaSessionId));
    }

    public ClientDtoResponse postClient(CreateClientDtoRequest clientDtoRequest) throws ServerException {
        Client client = clientMapper.dtoToModel(clientDtoRequest);
        userDao.insertFromClient(client);
        Integer userId = userDao.getIdByLogin(client.getLogin());
        sessionDao.insert(new Session(userId, UUID.randomUUID().toString()));
        return clientMapper.modelToDtoResponse(clientDao.insert(client, userId));
    }

    public UpdateClientDtoResponse updateClient(HttpServletRequest httpServletRequest,
                                                UpdateClientDtoRequest clientDtoRequest) throws ServerException {
        Session session = sessionService.getJavaSession(httpServletRequest);
        Client client = clientDao.getByJavaSessionId(session.getJavaSessionId());
        validateService.checkPasswordByLogin(clientDtoRequest.getOldPassword(), client.getLogin());
        Client upClient = clientMapper.updateDtoRequestToModel(client, clientDtoRequest);
        int userId = userDao.getIdByLogin(client.getLogin());
        userDao.updateFromClient(upClient, userId);
        clientDao.update(upClient, userId);
        return clientMapper.modelToUpdateDtoResponse(clientDao.getByJavaSessionId(session.getJavaSessionId()));
    }
}
