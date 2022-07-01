package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.SessionDao;
import com.akrauze.buscompany.model.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SessionDaoImpl extends DaoImplBase implements SessionDao {
    @Autowired
    SqlSession sqlSession;

    @Override
    public Session insert(Session session) {
        log.info("SessionDao insert session - " + session);
        getSessionMapper(sqlSession).insert(session);
        return session;
    }

    public Session getByUserId(int id) {
        log.info("SessionDao get Session by Id -" + id);
        return getSessionMapper(sqlSession).getByUserId(id);
    }

    @Override
    public Session getByJavaSessionId(String javaSessionId) {
        log.info("SessionDao get Session by javaSessionId - " + javaSessionId);
        return getSessionMapper(sqlSession).getByJavaSessionId(javaSessionId);
    }

    @Override
    public void updateSession(Session session) {
        log.info("SessionDao update Session");
        getSessionMapper(sqlSession).updateSession(session);
    }
}

