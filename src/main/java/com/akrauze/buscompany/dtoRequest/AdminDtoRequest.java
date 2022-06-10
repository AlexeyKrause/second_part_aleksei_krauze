package com.akrauze.buscompany.dtoRequest;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdminDtoRequest {
    int id;
    UserDtoRequest userDtoRequest;
    String position;
}
