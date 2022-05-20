package com.akrauze.buscompany.daoImpl;

import com.akrauze.buscompany.model.User;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends DaoImplBase {
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User getUser(int id) {
        log.info("Dao getUserById " + id);
        return this.getUserMapper(this.sqlSession).getById(id);
    }

    public User insert(User user) {
        log.debug("DAO insert User {}", user);
        log.info("DAO insert User {}", user);
        this.getUserMapper(this.sqlSession).insert(user);
        return user;
    }
}
