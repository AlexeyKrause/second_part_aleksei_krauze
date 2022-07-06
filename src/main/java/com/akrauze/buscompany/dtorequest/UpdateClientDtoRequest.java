package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class UpdateClientDtoRequest extends UpdateUserDtoRequest{
    @NotNull
    String email;
    @NotNull
    String phoneNumber;
}
