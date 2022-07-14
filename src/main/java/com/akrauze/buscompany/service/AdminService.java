package com.akrauze.buscompany.service;

import com.akrauze.buscompany.daoimpl.AdminDaoImpl;
import com.akrauze.buscompany.daoimpl.SessionDaoImpl;
import com.akrauze.buscompany.daoimpl.UserDaoImpl;
import com.akrauze.buscompany.dtorequest.CreateAdminDtoRequest;
import com.akrauze.buscompany.dtorequest.UpdateAdminDtoRequest;
import com.akrauze.buscompany.dtoresponse.CreateAdminDtoResponse;
import com.akrauze.buscompany.dtoresponse.UpdateAdminDtoResponse;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.mappers.AdminMapper;
import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;


@Service
@Transactional
public class AdminService {
    private final AdminDaoImpl adminDao;
    private final UserDaoImpl userDao;
    private final SessionDaoImpl sessionDao;
    private final AdminMapper adminMapper;
    private final SessionService sessionService;
    private final ValidateService validateService;


    public AdminService(AdminDaoImpl adminDao, UserDaoImpl userDao, SessionDaoImpl sessionDao, AdminMapper adminMapper,
                        SessionService sessionService, ValidateService validateService) {
        this.adminDao = adminDao;
        this.userDao = userDao;
        this.sessionDao = sessionDao;
        this.adminMapper = adminMapper;
        this.sessionService = sessionService;
        this.validateService = validateService;
    }

    public CreateAdminDtoResponse getById(int id) {
        return adminMapper.modelToDtoResponse(adminDao.getById(id));
    }

    public CreateAdminDtoResponse getByJavaSessionId(String javaSessionId) {
        return adminMapper.modelToDtoResponse(adminDao.getByJavaSessionId(javaSessionId));
    }

    public CreateAdminDtoResponse postAdmin(CreateAdminDtoRequest adminDtoRequest) {
        Admin admin = adminMapper.dtoToModel(adminDtoRequest);
        userDao.insertFromAdmin(admin);
        int userId = userDao.getIdByLogin(admin.getLogin());
        sessionDao.insert(new Session(userId));
        return adminMapper.modelToDtoResponse(adminDao.insert(admin, userId));
    }

    public UpdateAdminDtoResponse updateAdmin(HttpServletRequest httpServletRequest,
                                              UpdateAdminDtoRequest adminDtoRequest) throws ServerException {
        Session session = sessionService.getJavaSession(httpServletRequest);
        Admin admin = adminDao.getByJavaSessionId(session.getJavaSessionId());
        validateService.checkPasswordByLogin(adminDtoRequest.getOldPassword(), admin.getLogin());
        Admin upAdmin = adminMapper.updateDtoRequestToModel(admin, adminDtoRequest);
        int userId = userDao.getIdByLogin(upAdmin.getLogin());
        userDao.updateFromAdmin(upAdmin, userId);
        adminDao.update(upAdmin, userId);
        return adminMapper.modelToUpdateDtoResponse(adminDao.getByJavaSessionId(session.getJavaSessionId()));
    }
}
