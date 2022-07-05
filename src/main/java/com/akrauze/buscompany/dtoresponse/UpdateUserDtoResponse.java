package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class UpdateUserDtoResponse {
    String firstName;
    String lastName;
    String patronymic;
}