package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.Client;

public interface UserDao {
    void insertFromAdmin(Admin admin);

    void insertFromClient(Client client);

    Integer getIdByLogin(String login);

    String getPassByLogin(String login);

    String getUserRoleByLogin(String login);



    void delete(int id);
}
