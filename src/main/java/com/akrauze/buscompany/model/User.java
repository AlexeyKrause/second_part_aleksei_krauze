package com.akrauze.buscompany.model;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

//    @Autowired
//    ApplicationProperties applicationProperties;

    @Setter(AccessLevel.NONE)
    int id;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    String patronymic;
    @NotNull
    String login;

//    @Value("${min_password_length}")
//    int asd;

    @NotNull
    @Pattern(regexp = "^.(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,20}$", message = "Password must contain an uppercase letter, " +
            "a lowercase letter, a number, a symbol!")
//    @Min(value = asd)
    String password;
    @NotNull
    String role;
    Boolean isActiv;
//    Boolean sessionActiv;


//    public User(int id, String firstName, String lastName, String patronymic,
//                String login, String password, String role, boolean isActiv) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.patronymic = patronymic;
//        this.login = login;
//        this.password = password;
//        this.role = role;
//        this.isActiv = isActiv;
//    }
}
