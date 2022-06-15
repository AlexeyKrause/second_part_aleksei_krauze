package com.akrauze.buscompany.daoimpl;


import com.akrauze.buscompany.dao.AdminDao;
import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class AdminDaoImpl extends DaoImplBase implements AdminDao {
    @Autowired
    SqlSession sqlSession;

    public AdminDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Admin getById(int id) {
        log.info("Dao getAdminById - " + id);
        Admin admin = getAdminMapper(sqlSession).getById(id);
        log.info("Dao getAdminById - " + admin);
        return admin;
    }

//    public Admin getAdminByLogin(String login) throws ServerException {
//        log.info("Dao getAdminByLogin " + login);
//        return getAdminMapper(sqlSession).getByLogin(login);
//    }
    @Override
    public Admin insert(Admin admin, User user) {
        log.info("DAO insert Admin {}", admin);
    getAdminMapper(sqlSession).insert(admin, user);
        return admin;
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
