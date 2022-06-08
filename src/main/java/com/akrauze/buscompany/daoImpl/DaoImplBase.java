package com.akrauze.buscompany.daoImpl;


import com.akrauze.buscompany.myBatis.mapper.AdminMapper;
import com.akrauze.buscompany.myBatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

public class DaoImplBase {

    protected UserMapper getUserMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(UserMapper.class);
    }

    protected AdminMapper getAdminMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(AdminMapper.class);
    }

}