package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateAdminDtoResponse extends UpdateUserDtoResponse{
    String position;
    String userType;
}
