package com.akrauze.buscompany.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin extends User {
    String position;

    public Admin(String firstName, String lastName, String patronymic, String login, String password, String position) {
        super(firstName, lastName, patronymic, login, password);
        this.position = position;
    }
}
