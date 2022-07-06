package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateClientDtoResponse extends UpdateUserDtoResponse {
    String email;
    String phoneNumber;
    String userType;
}
