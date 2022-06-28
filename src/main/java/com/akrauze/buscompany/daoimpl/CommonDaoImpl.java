package com.akrauze.buscompany.daoimpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CommonDaoImpl extends DaoImplBase{
    @Autowired
    SqlSession sqlSession;

    public void clear() {
        log.debug("Clear Database");
        try {
            getAdminMapper(sqlSession).deleteAll();
            getClientMapper(sqlSession).deleteAll();
            getUserMapper(sqlSession).deleteAll();
            getSessionMapper(sqlSession).delete();
        } catch (RuntimeException ex) {
            log.info("Can't clear database");
            sqlSession.rollback();
            throw ex;
        }
        sqlSession.commit();
    }
}
