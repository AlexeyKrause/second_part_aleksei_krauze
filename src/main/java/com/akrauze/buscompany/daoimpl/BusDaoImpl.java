package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.BusDao;
import com.akrauze.buscompany.model.Bus;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class BusDaoImpl extends DaoImplBase implements BusDao {
    @Autowired
    private  final SqlSession sqlSession;

    public BusDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Bus> getAll() {
        log.info("BusDao getAll Bus");
        return getBusMapper(sqlSession).getAll();
    }

    @Override
    public Bus getByName(String busName) {
        log.info("BusDao get Bus by busName {}", busName);
        return getBusMapper(sqlSession).getByName(busName);
    }
}
