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
        log.info("Dao getUserByLogin " + login);
        return getUserMapper(sqlSession).getIdByLogin(login);
    }

    @Override
    public String getPassByLogin(String login) {
        log.info("Dao getPasswordByLogin " + login);
        return getUserMapper(sqlSession).getPassByLogin(login);
    }

    @Override
    public String getUserRoleByLogin(String login) {
        log.info("Dao getUserRoleByLogin " + login);
        return getUserMapper(sqlSession).getUserRoleByLogin(login);
    }

    @Override
    public void insertFromAdmin(Admin admin) {
        log.info("DAO insert User from Admin {admin} - " + admin);
        getUserMapper(sqlSession).insertFromAdmin(admin);
    }

    @Override
    public void insertFromClient(Client client) {
        log.info("DAO insert User from Client {client} - " + client);
        getUserMapper(sqlSession).insertFromClient(client);
    }


    @Override
    public void delete(int id) {

    }
}