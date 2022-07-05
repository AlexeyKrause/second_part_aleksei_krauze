package com.akrauze.buscompany.daoimpl;


import com.akrauze.buscompany.dao.AdminDao;
import com.akrauze.buscompany.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class AdminDaoImpl extends DaoImplBase implements AdminDao {
    @Autowired
    private final SqlSession sqlSession;

    public AdminDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Admin getById(int id) {
        log.info("AdminDao getAdminById - " + id);
        Admin admin = getAdminMapper(sqlSession).getById(id);
        log.info("AdminDao getAdminById {} - ", admin);
        return admin;
    }

    @Override
    public Admin getByLogin(String login) {
        log.info("AdminDao getAdminByLogin {} - ", login);
        return getAdminMapper(sqlSession).getByILogin(login);
    }

    @Override
    public Admin getByJavaSessionId(String javaSessionId) {
        log.info("AdminDao getAdminByJavaSessionId {} - ", javaSessionId);
        return getAdminMapper(sqlSession).getByJavaSessionId(javaSessionId);
    }

    @Override
    public Admin insert(Admin admin, int userId) {
        log.info("AdminDao insert Admin {} - ", admin);
        getAdminMapper(sqlSession).insert(admin, userId);
        return admin;
    }

    @Override
    public void update(Admin admin, int userId) {
        log.info("AdminDao update Admin {}, where userId {} - ", admin, userId);
        getAdminMapper(sqlSession).update(admin, userId);
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void deleteAll() {

    }


}
