package com.akrauze.buscompany.model;


import lombok.*;


@Data
public class User {
    int id;
    String firstName;
    String lastName;
    String patronymic;
    String login;
    String password;
    String role;
    Boolean isActiv;
}
