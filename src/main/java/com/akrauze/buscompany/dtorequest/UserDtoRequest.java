package com.akrauze.buscompany.dtorequest;

import com.akrauze.buscompany.model.enums.UserRole;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    String patronymic;
    @NotNull
    String login;
    @NotNull
//    @Pattern(regexp = "^.(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{0,20}$", message = "Password must contain an uppercase letter, " +
//            "a lowercase letter, a number, a symbol!")
//    @Min(value = "${min_password_length}")
//    @Min(value = 1, message = "Length password must be between 8 and 20 characters")
    String password;
    @NotNull
    UserRole userRole;
}
