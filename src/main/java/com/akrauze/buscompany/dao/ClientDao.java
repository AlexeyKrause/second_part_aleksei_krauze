package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.Client;

public interface ClientDao {

    Client insert(Client client, int userId);

    Client getById(int id);

    Client update(Client client);

    void delete(int id);
}
