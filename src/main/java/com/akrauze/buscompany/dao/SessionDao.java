package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.Session;

public interface SessionDao {
    Session insert(Session session);

    Session getByUserId(int id);

    Session getByJavaSessionId(String javaSessionId);

    void updateSession(Session session);
}
