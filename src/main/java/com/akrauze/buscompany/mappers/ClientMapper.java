package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.CreateClientDtoRequest;
import com.akrauze.buscompany.dtorequest.UpdateClientDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.dtoresponse.UpdateClientDtoResponse;
import com.akrauze.buscompany.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client dtoToModel(CreateClientDtoRequest clientDtoRequest);

    @Mapping(target = "userType", constant = "client")
    ClientDtoResponse modelToDtoResponse(Client client);

    @Mapping(source = "clientDtoRequest.firstName", target = "firstName")
    @Mapping(source = "clientDtoRequest.lastName", target = "lastName")
    @Mapping(source = "clientDtoRequest.patronymic", target = "patronymic")
    @Mapping(source = "client.login", target = "login")
    @Mapping(source = "clientDtoRequest.newPassword", target = "password")
    @Mapping(source = "client.userRole", target = "userRole")
    @Mapping(source = "clientDtoRequest.email", target = "email")
    @Mapping(source = "clientDtoRequest.phoneNumber", target = "phoneNumber")
    Client updateDtoRequestToModel(Client client, UpdateClientDtoRequest clientDtoRequest);

    @Mapping(source = "client.firstName", target = "firstName")
    @Mapping(source = "client.lastName", target = "lastName")
    @Mapping(source = "client.patronymic", target = "patronymic")
    @Mapping(source = "client.email", target = "email")
    @Mapping(source = "client.phoneNumber", target = "phoneNumber")
    @Mapping(target = "userType", constant = "client")
    UpdateClientDtoResponse modelToUpdateDtoResponse(Client client);
}

