package com.akrauze.buscompany.model;


import com.akrauze.buscompany.model.enums.Roles;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Setter(AccessLevel.NONE)
    int id;
    Roles role;
    Set<User> users;
}
