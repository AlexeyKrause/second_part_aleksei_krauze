package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Client extends User {
    int id;
    User user;
    String email;
    int telefonNumber;
}
