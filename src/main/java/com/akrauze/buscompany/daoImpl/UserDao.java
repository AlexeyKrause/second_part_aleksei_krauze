package com.akrauze.buscompany.daoImpl;

import com.akrauze.buscompany.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Repository
public class UserDao extends DaoImplBase {

    @Autowired
    SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User getUser(int id) {
        log.info("Dao getUserById " + id);
        return getUserMapper(sqlSession).getById(id);
    }

    public User getByLogin(String login) {
        User user = getUserMapper(sqlSession).getByLogin(login);
        log.info("Dao getUserByLogin " + login + "User - " + user);
        return user;
    }

    public User insert(User user) {
        log.info("DAO insert User {}", user);
        getUserMapper(sqlSession).insert(user);
        return user;
    }
}
