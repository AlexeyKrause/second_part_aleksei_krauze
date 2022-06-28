package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.User;


public interface Dao<T> {
    T insert(T t, int userId);

    T getById(int id);

    T getByLogin(String login);

    T update(T t);

    void delete(int id);

    void deleteAll();
}
