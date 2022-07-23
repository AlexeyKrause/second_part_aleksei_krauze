package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.TripDao;
import com.akrauze.buscompany.model.Trip;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TripDaoImpl extends DaoImplBase implements TripDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public Integer insert(Trip trip) {
        log.info("TripDao insert TripSchedule {}", trip);
        return getTripMapper(sqlSession).insert(trip);
    }

}
