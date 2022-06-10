package com.akrauze.buscompany.dtoRequest;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {
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
    @Pattern(regexp = "^.(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{0,20}$", message = "Password must contain an uppercase letter, " +
            "a lowercase letter, a number, a symbol!")
//    @Min(value = "${min_password_length}")
//    @Min(value = 1, message = "Length password must be between 8 and 20 characters")
    String password;
    @NotNull
    String role;
    Boolean isActiv;
}
