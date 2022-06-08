package com.akrauze.buscompany.daoImpl;


import com.akrauze.buscompany.model.Admin;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class AdminDao extends DaoImplBase{
    @Autowired
    SqlSession sqlSession;

    public AdminDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Admin getAdminById(int id) {
        log.info("Dao getAdminById - " + id);
        Admin admin = getAdminMapper(sqlSession).getById(id);
        log.info("Dao getAdminById - " + admin);
        return admin;
    }
//
//    public Admin getAdminByLogin(String login) throws MyException {
//        log.info("Dao getAdminByLogin " + login);
//        return getAdminMapper(sqlSession).getByLogin(login);
//    }

    public Admin insert(Admin admin) {
        log.info("DAO insert Admin {}", admin);
    getAdminMapper(sqlSession).insert(admin);
        return admin;
    }
}
