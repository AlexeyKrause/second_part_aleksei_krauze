package com.akrauze.buscompany.model;


import lombok.*;

@Data
@ToString
public class Admin {
    @Setter(AccessLevel.NONE)
    int id;
    User user;
    String position;
}
