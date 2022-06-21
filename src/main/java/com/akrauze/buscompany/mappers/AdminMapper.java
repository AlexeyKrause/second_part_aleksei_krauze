package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.AdminDtoRequest;
import com.akrauze.buscompany.dtoresponse.AdminDtoResponse;
import com.akrauze.buscompany.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin dtoToModel(AdminDtoRequest adminDtoRequest);

    @Mapping(target = "userType", constant = "admin")
    AdminDtoResponse modelToDtoResponse(Admin admin);
}
