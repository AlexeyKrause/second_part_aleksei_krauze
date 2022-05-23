package com.akrauze.buscompany.daoImpl;

import com.akrauze.buscompany.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserDao extends DaoImplBase {

    SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User getUser(int id) {
        log.info("Dao getUserById " + id);
        return this.getUserMapper(this.sqlSession).getById(id);
    }

    public User insert(User user) {
        log.info("DAO insert User {}", user);
        this.getUserMapper(this.sqlSession).insert(user);
        return user;
    }
}
