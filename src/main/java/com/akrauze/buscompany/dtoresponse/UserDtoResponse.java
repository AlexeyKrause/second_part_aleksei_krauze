package com.akrauze.buscompany.dtoresponse;

import lombok.Data;

@Data
public abstract class UserDtoResponse {
    int id;
    String firstName;
    String lastName;
    String patronymic;
}
