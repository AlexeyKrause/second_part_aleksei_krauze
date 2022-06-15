package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.model.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SessionDaoImpl extends DaoImplBase {
    @Autowired
    SqlSession sqlSession;

    public Session insert(Session session) {
        log.info("DAO insert session - " + session);
        getSessionMapper(sqlSession).insert(session);
        return session;
    }


    public Session getById(int id) {
        log.info("DAO get Session by Id -" + id);
        return getSessionMapper(sqlSession).getById(id);
    }
}

