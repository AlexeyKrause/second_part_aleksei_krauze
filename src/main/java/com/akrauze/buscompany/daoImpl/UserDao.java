package com.akrauze.buscompany.daoImpl;

import com.akrauze.buscompany.MyBatisUtils;
import com.akrauze.buscompany.myBatis.mapper.UserMapper;
import com.akrauze.buscompany.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    MyBatisUtils myBatisUtils;

    public User getUser(int id) {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession()) {
            try {
                return sqlSession.getMapper(UserMapper.class).getById(id);
            } catch (RuntimeException ex) {
                throw ex;
            }
        }
    }

    public User insert(User user) {
//        LOGGER.debug("DAO insert Trainee {}", group, trainee);
        if (!MyBatisUtils.initSqlSessionFactory()) {
            throw new RuntimeException("Can't create connection, stop");
        }
        try (SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession()) {
            try {
                sqlSession.getMapper(UserMapper.class).insert(user);
            } catch (RuntimeException ex) {
//                LOGGER.info("Can't insert User {}" + user, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return user;
    }
}

