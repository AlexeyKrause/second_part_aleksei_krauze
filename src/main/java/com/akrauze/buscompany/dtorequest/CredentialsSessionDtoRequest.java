package com.akrauze.buscompany.dtorequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsSessionDtoRequest {
    @NotNull
    String login;
    @NotNull
    String password;
}
