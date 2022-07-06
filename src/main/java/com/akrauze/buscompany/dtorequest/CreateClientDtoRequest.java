package com.akrauze.buscompany.dtorequest;


import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class CreateClientDtoRequest extends CreateUserDtoRequest {
    @NotNull
    String email;
    @NotNull
    int phoneNumber;
}
