package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public abstract class UpdateUserDtoRequest {
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    String patronymic;
    //will add custom password validator
    String oldPassword;
    //will add custom password validator
    String newPassword;
}
