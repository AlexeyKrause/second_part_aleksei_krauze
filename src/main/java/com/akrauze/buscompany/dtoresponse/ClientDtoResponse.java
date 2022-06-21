package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientDtoResponse extends UserDtoResponse{
    int id;
    String email;
    // REVU phoneNumber
    int telefonNumber;
    String userType;
}
