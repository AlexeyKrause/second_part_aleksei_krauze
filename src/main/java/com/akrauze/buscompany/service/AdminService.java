package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.AdminDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.AdminDtoRequest;
import com.akrauze.buscompany.dtoresponse.AdminDtoResponse;
import com.akrauze.buscompany.mappers.AdminMapper;
import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AdminService {
    private final AdminDaoImpl adminDao;
    private final UserDaoImpl userDao;
    private final SessionDaoImpl sessionDao;
    private final AdminMapper adminMapper;


    public AdminService(AdminDaoImpl adminDao, UserDaoImpl userDao, SessionDaoImpl sessionDao, AdminMapper adminMapper) {
        this.adminDao = adminDao;
        this.userDao = userDao;
        this.sessionDao = sessionDao;
        this.adminMapper = adminMapper;
    }

    public AdminDtoResponse getAdminById(int id) {
        return adminMapper.modelToDtoResponse(adminDao.getById(id));
    }

    public AdminDtoResponse postAdmin(AdminDtoRequest adminDtoRequest) {
        Admin admin = adminMapper.dtoToModel(adminDtoRequest);
        userDao.insertFromAdmin(admin);
        int userId = userDao.getIdByLogin(admin.getLogin());
        sessionDao.insert(new Session(userId));
        return adminMapper.modelToDtoResponse(adminDao.insert(admin, userId));
    }
}
