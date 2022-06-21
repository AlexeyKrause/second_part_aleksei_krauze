package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.ClientDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    public final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDtoResponse getById(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDtoResponse postClient(@Valid @RequestBody ClientDtoRequest clientDtoRequest) {
        return clientService.potClient(clientDtoRequest);
    }
}
