package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.UserDao;
import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserDaoImpl extends DaoImplBase implements UserDao {

    @Autowired
    SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


//    public User getById(int id) {
//        log.info("Dao getUserById " + id);
//        return getUserMapper(sqlSession).getById(id);
//    }

    @Override
    public Integer getIdByLogin(String login) {
        log.info("UserDao getUserByLogin " + login);
        return getUserMapper(sqlSession).getIdByLogin(login);
    }

    @Override
    public String getPassByLogin(String login) {
        log.info("UserDao getPasswordByLogin " + login);
        return getUserMapper(sqlSession).getPassByLogin(login);
    }

    @Override
    public String getUserRoleByLogin(String login) {
        log.info("UserDao getUserRoleByLogin " + login);
        return getUserMapper(sqlSession).getUserRoleByLogin(login);
    }

    @Override
    public String getUserRoleByJavaSessionId(String javaSessionId) {
        log.info("UserDao getUserRoleByJavaSessionId {} - ", javaSessionId);
        return getUserMapper(sqlSession).getUserRoleByJavaSessionId(javaSessionId);
    }

    @Override
    public int getCountLogin(String login) {
        log.info("UserDao getCountLogin");
        return getUserMapper(sqlSession).getCountLogin(login);
    }

    @Override
    public void insertFromAdmin(Admin admin) {
        log.info("UserDao insert User from Admin {admin} - " + admin);
        getUserMapper(sqlSession).insertFromAdmin(admin);
    }

    @Override
    public void insertFromClient(Client client) {
        log.info("UserDao insert User from Client {client} - " + client);
        getUserMapper(sqlSession).insertFromClient(client);
    }

    @Override
    public void updateFromAdmin(Admin admin, int userId) {
        log.info("UserDao update user from Admin {} - ", admin);
        getUserMapper(sqlSession).updateFromAdmin(admin, userId);
    }

    @Override
    public void updateFromClient(Client client, int userId) {
        log.info("UserDao update user from Client {} - ", client);
        getUserMapper(sqlSession).updateFromClient(client, userId);
    }

    @Override
    public void delete(int id) {

    }
}
