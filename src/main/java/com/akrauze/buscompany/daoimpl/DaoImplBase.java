package com.akrauze.buscompany.daoimpl;


import com.akrauze.buscompany.myBatis.mapper.AdminMapper;
import com.akrauze.buscompany.myBatis.mapper.ClientMapper;
import com.akrauze.buscompany.myBatis.mapper.SessionMapper;
import com.akrauze.buscompany.myBatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

public class DaoImplBase {

    protected UserMapper getUserMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(UserMapper.class);
    }

    protected AdminMapper getAdminMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(AdminMapper.class);
    }

    protected ClientMapper getClientMapper(SqlSession sqlSession) {return sqlSession.getMapper(ClientMapper.class);}

    protected SessionMapper getSessionMapper(SqlSession sqlSession) {return  sqlSession.getMapper(SessionMapper.class);};

}