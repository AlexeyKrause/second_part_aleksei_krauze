package com.akrauze.buscompany.model;


import com.akrauze.buscompany.model.enums.Roles;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
//    @Size(@Value("${min_password_length}"))
    String password;
    @NotNull
    String role;
    Boolean isActiv;
//    Boolean sessionActiv;

    public User(int id, String firstName, String lastName, String patronymic,
                String login, String password, String role, boolean isActiv) {
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
