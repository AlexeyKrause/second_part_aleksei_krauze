package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Session {
    int id;
    int userId;
    boolean isActive;

    public Session(int userId) {
        setUserId(userId);
    }
}
