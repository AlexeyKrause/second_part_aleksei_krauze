package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class UpdateUserDtoRequest {
    String firstName;
    String lastName;
    String patronymic;
    String oldPassword;
    String newPassword;
}
