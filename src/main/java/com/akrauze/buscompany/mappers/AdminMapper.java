package com.akrauze.buscompany.mappers;

import com.akrauze.buscompany.dtorequest.CreateAdminDtoRequest;
import com.akrauze.buscompany.dtorequest.UpdateAdminDtoRequest;
import com.akrauze.buscompany.dtoresponse.CreateAdminDtoResponse;
import com.akrauze.buscompany.dtoresponse.UpdateAdminDtoResponse;
import com.akrauze.buscompany.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin dtoToModel(CreateAdminDtoRequest adminDtoRequest);

    @Mapping(target = "userType", constant = "admin")
    CreateAdminDtoResponse modelToDtoResponse(Admin admin);

    @Mapping(source = "adminDtoRequest.firstName", target = "firstName")
    @Mapping(source = "adminDtoRequest.lastName", target = "lastName")
    @Mapping(source = "adminDtoRequest.patronymic", target = "patronymic")
    @Mapping(source = "admin.login", target = "login")
    @Mapping(source = "adminDtoRequest.newPassword", target = "password")
    @Mapping(source = "admin.userRole", target = "userRole")
    @Mapping(source = "adminDtoRequest.position", target = "position")
    Admin updateDtoRequestToModel(Admin admin, UpdateAdminDtoRequest adminDtoRequest);

    @Mapping(source = "admin.firstName", target = "firstName")
    @Mapping(source = "admin.lastName", target = "lastName")
    @Mapping(source = "admin.patronymic", target = "patronymic")
    @Mapping(source = "admin.position", target = "position")
    @Mapping(target = "userType", constant = "admin")
    UpdateAdminDtoResponse modelToUpdateDtoResponse(Admin admin);
}
