package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateAdminDtoResponse extends UserDtoResponse {
    int id;
    String position;
    String userType;
}
