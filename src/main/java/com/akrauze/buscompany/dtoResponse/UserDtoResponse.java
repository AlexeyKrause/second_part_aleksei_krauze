package com.akrauze.buscompany.dtoResponse;

import lombok.Data;

@Data
public class UserDtoResponse {
    int id;
    String firstName;
    String lastName;
    String patronymic;
    String login;
    String password;
    String role;
    Boolean isActiv;
}
