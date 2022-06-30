package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.ClientDtoRequest;
import com.akrauze.buscompany.dtorequest.CredentialsSessionDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.ClientService;
import com.akrauze.buscompany.service.SessionService;
import com.akrauze.buscompany.service.ValidateService;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    public final ClientService clientService;
    public final SessionService sessionService;
    public final ValidateService validateService;

    public ClientController(ClientService clientService, SessionService sessionService, ValidateService validateService) {
        this.clientService = clientService;
        this.sessionService = sessionService;
        this.validateService = validateService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDtoResponse getById(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDtoResponse postClient(@Valid @RequestBody ClientDtoRequest clientDtoRequest, HttpServletResponse httpServletResponse) throws ServerException {
        validateService.checkNewLogin(clientDtoRequest.getLogin());
        clientService.postClient(clientDtoRequest);
        return sessionService.login(new CredentialsSessionDtoRequest(clientDtoRequest.getLogin(), clientDtoRequest.getPassword()), httpServletResponse);
    }
}
