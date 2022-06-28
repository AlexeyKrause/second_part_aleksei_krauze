package com.akrauze.buscompany.dtorequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
@AllArgsConstructor
public class SessionDtoRequest {
    @NotNull
    String login;
    @NotNull
    String password;
}
