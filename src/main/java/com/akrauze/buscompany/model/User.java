package com.akrauze.buscompany.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    int id;
    String name;

    public User(String name) {
        this.name = name;
    }
}
