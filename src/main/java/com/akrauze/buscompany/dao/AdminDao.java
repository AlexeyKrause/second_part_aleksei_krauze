package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.User;

public interface AdminDao {

    Admin insert(Admin admin, User user);

    Admin getById(int id);

    Admin update(Admin admin);

    void delete(int id);
}
