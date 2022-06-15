package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.User;

public interface UserDao {
    User insert(User user);

    User getById(int id);

    User getUserByLogin(String login);

    User update(User user);

    void delete(int id);
}
