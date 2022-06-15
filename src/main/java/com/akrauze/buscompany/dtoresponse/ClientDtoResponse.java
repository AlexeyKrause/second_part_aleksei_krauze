package com.akrauze.buscompany.dtoresponse;

import com.akrauze.buscompany.model.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientDtoResponse extends UserDtoResponse{
    int id;
    String email;
    int telefonNumber;
    String userType;
}
