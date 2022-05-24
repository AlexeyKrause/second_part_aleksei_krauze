package com.akrauze.buscompany.model;

import com.akrauze.buscompany.model.enums.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Client extends User {
    String email;
    int telefonNumber;

    public Client(int id, String firstName, String lastName, String patronymic, String login, String password,
                  Roles role, boolean isActiv, String email, int telefonNumber) {
        super(id, firstName, lastName, patronymic, login, password, role, isActiv);
        this.email = email;
        this.telefonNumber = telefonNumber;
    }
}
