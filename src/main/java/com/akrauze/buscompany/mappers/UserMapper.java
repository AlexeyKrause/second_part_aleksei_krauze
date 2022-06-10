package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtoRequest.UserDtoRequest;
import com.akrauze.buscompany.dtoResponse.UserDtoResponse;
import com.akrauze.buscompany.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserDtoRequest userDtoRequest);
    UserDtoResponse modelToDtoResponse(User user);
}
