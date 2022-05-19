package com.akrauze.buscompany.model;


import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class User {
    @Setter(AccessLevel.NONE)
    int id;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    String patronymic;
    @NotNull
    String login;
    @NotNull
    String password;


    public User(String firstName, String lastName, String patronymic, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
    }
}
