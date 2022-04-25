package com.akrauze.buscompany.daoImpl;

import com.akrauze.buscompany.MyBatisUtils;
import com.akrauze.buscompany.mapper.UserMapper;
import com.akrauze.buscompany.model.User;
import org.apache.ibatis.session.SqlSession;

public class TestTest {


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
        try (SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession()) {
            try {
                sqlSession.getMapper(UserMapper.class).insert(user);
            } catch (RuntimeException ex) {
//                LOGGER.info("Can't insert Trainee {} {}",trainee, group, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
        return user;
    }
}

