package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.UserDao;
import com.akrauze.buscompany.exception.ServerException;
import com.akrauze.buscompany.model.User;
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

    @Override
    public User getById(int id) {
        log.info("Dao getUserById " + id);
        return getUserMapper(sqlSession).getById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        log.info("Dao getUserByLogin " + login);
        return getUserMapper(sqlSession).getByLogin(login);
    }

    @Override
    public User insert(User user) {
        log.info("DAO insert User {}", user);
        getUserMapper(sqlSession).insert(user);
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
