package com.akrauze.buscompany.model;


import com.akrauze.buscompany.model.enums.UserRole;
import lombok.*;


@Data
@ToString
// REVU abstract ?
public class User {
    int id;
    String firstName;
    String lastName;
    String patronymic;
    String login;
    String password;
    UserRole userRole;
}
