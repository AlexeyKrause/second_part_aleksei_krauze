package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.Client;

import java.util.List;

public interface ClientDao {

    Client insert(Client client, int userId);

    Client getById(int id);

    Client getByLogin(String login);

    Client getByJavaSessionId(String javaSessionId);

    List<Client> getAll();

    Client update(Client client);

    void delete(int id);
}
