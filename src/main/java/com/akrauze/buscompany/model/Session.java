package com.akrauze.buscompany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    int id;
    int userId;
    boolean isActive;
    String javaSessionId;

    public Session(int userId) {
        setUserId(userId);
    }

    public Session(int userId, String javaSessionId) {
        setUserId(userId);
        setJavaSessionId(javaSessionId);
    }

    public Session(int userId, boolean isActive) {
        setUserId(userId);
        setActive(isActive);
    }

    public Session(int userId, boolean isActive, String javaSessionId) {
        setUserId(userId);
        setActive(isActive);
        setJavaSessionId(javaSessionId);
    }
}
