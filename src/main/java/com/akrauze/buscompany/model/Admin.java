package com.akrauze.buscompany.model;


import com.akrauze.buscompany.model.enums.Roles;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin extends User {
    int id;
    User user;
    String position;

    public Admin(int id, String firstName, String lastName, String patronymic, String login,
                 String password, String role, boolean isActiv, String position) {
        super(id, firstName, lastName, patronymic, login, password, role, isActiv);
        this.position = position;
    }
}
