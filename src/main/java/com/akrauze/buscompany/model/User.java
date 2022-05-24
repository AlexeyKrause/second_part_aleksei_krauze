package com.akrauze.buscompany.model;


import com.akrauze.buscompany.model.enums.Roles;
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
    @NotNull
    Roles role;
    Boolean isActiv;
//    Boolean sessionActiv;

    public User(int id, String firstName, String lastName, String patronymic,
                String login, String password, Roles role, boolean isActiv) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isActiv = isActiv;
    }
}
