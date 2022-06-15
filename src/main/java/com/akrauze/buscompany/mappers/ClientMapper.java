package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.ClientDtoRequest;
import com.akrauze.buscompany.dtoresponse.ClientDtoResponse;
import com.akrauze.buscompany.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client dtoToModel(ClientDtoRequest clientDtoRequest);

    @Mapping(target = "userType", constant = "client")
    ClientDtoResponse modelToDtoResponse(Client client);
}
