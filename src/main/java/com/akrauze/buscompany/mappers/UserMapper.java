package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.AdminDtoRequest;
import com.akrauze.buscompany.dtorequest.ClientDtoRequest;
import com.akrauze.buscompany.dtorequest.UserDtoRequest;
//import com.akrauze.buscompany.dtoresponse.UserDtoResponse;
import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.Client;
import com.akrauze.buscompany.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserDtoRequest userDtoRequest);

//    UserDtoResponse modelToDtoResponse(User user);

    UserDtoRequest adminDtoToUserDto(AdminDtoRequest adminDtoRequest);

    User clientDtoToUserDto(ClientDtoRequest clientDtoRequest);
}
