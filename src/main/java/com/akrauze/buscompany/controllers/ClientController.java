package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.ClientDtoRequest;
import com.akrauze.buscompany.dtorequest.SessionDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.ClientService;
import com.akrauze.buscompany.service.SessionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    public final ClientService clientService;
    public final SessionService sessionService;

    public ClientController(ClientService clientService, SessionService sessionService) {
        this.clientService = clientService;
        this.sessionService = sessionService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDtoResponse getById(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDtoResponse postClient(@Valid @RequestBody ClientDtoRequest clientDtoRequest, HttpServletResponse httpServletResponse) throws ServerException {
        clientService.potClient(clientDtoRequest);
        return sessionService.login(new SessionDtoRequest(clientDtoRequest.getLogin(), clientDtoRequest.getPassword()), httpServletResponse);
    }
}
