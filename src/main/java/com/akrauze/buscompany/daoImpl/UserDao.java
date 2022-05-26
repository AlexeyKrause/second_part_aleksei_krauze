package com.akrauze.buscompany.daoImpl;

import com.akrauze.buscompany.exception.ErrorCode;
import com.akrauze.buscompany.exception.MyException;
import com.akrauze.buscompany.model.User;
import com.fasterxml.jackson.datatype.jdk8.OptionalDoubleSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
public class UserDao extends DaoImplBase {

    @Autowired
    SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User getUserById(int id) {
        log.info("Dao getUserById " + id);
        return getUserMapper(sqlSession).getById(id);
    }

    public User getUserByLogin(String login) throws MyException {
        log.info("Dao getUserByLogin " + login);
        return getUserMapper(sqlSession).getByLogin(login);
    }

    public User insert(User user) {
        log.info("DAO insert User {}", user);
        getUserMapper(sqlSession).insert(user);
        return user;
    }
}
