package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Client extends User {
    String email;
    int telefonNumber;

    public Client(String firstName, String lastName, String patronymic, String login, String password, String email, int telefonNumber) {
        super(firstName, lastName, patronymic, login, password);
        this.email = email;
        this.telefonNumber = telefonNumber;
    }
}
