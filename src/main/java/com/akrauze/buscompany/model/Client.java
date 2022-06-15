package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Client extends User {
    int id;
    String email;
    int telefonNumber;
}
