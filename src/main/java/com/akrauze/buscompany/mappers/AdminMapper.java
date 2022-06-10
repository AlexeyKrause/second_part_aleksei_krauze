package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtoRequest.AdminDtoRequest;
import com.akrauze.buscompany.dtoResponse.AdminDtoResponse;
import com.akrauze.buscompany.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mapping(source = "userDtoRequest", target = "user")
    Admin dtoToModel(AdminDtoRequest adminDtoRequest);
    AdminDtoResponse modelToDtoResponse(Admin admin);
}
