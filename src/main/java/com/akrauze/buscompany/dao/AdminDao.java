package com.akrauze.buscompany.dao;

import com.akrauze.buscompany.model.Admin;

public interface AdminDao {

    Admin insert(Admin admin, int userId);

    Admin getById(int id);

    Admin update(Admin admin);

    void delete(int id);
}
