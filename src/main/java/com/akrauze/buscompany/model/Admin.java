package com.akrauze.buscompany.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@JsonSerialize
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    @Setter(AccessLevel.NONE)
    int id;
    User user;
    String position;

//    public Admin(User user, String position) {
//        setUser(user);
//        setPosition(position);
//    }
}
