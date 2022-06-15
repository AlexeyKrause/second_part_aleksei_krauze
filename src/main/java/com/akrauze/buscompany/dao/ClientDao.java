package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.Client;
import com.akrauze.buscompany.model.User;

public interface ClientDao {

    Client insert(Client client, User user);

    Client getById(int id);

    Client update(Client client);

    void delete(int id);
}
