package com.akrauze.buscompany.controllers;

import com.akrauze.buscompany.dtorequest.*;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.dtoresponse.UpdateClientDtoResponse;
import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.service.ClientService;
import com.akrauze.buscompany.service.SessionService;
import com.akrauze.buscompany.service.UserService;
import com.akrauze.buscompany.service.ValidateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    public final ClientService clientService;
    public final SessionService sessionService;
    public final ValidateService validateService;
    private final UserService userService;

    public ClientController(ClientService clientService, SessionService sessionService,
                            ValidateService validateService, UserService userService) {
        this.clientService = clientService;
        this.sessionService = sessionService;
        this.validateService = validateService;
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDtoResponse> getAllClient(HttpServletRequest httpServletRequest) throws ServerException {
        if (userService.getUserRoleByJavaSessionId(sessionService.getJavaSessionId(httpServletRequest)
                .getJavaSessionId()).equals("ADMIN"))
            return clientService.getAllClient();
        else
            throw new ServerException(ErrorCode.YOU_DONT_HAVE_PERMISSION, "userRole");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDtoResponse getById(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDtoResponse postClient(@Valid @RequestBody CreateClientDtoRequest clientDtoRequest,
                               HttpServletResponse httpServletResponse) throws ServerException {
        validateService.checkNewLogin(clientDtoRequest.getLogin());
        clientService.postClient(clientDtoRequest);
        return sessionService.login(new CredentialsSessionDtoRequest(clientDtoRequest.getLogin(),
                clientDtoRequest.getPassword()), httpServletResponse);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateClientDtoResponse updateClient(HttpServletRequest httpServletRequest, @Valid @RequestBody
            UpdateClientDtoRequest clientDtoRequest) throws ServerException {
        return clientService.updateClient(httpServletRequest, clientDtoRequest);
    }
}
