package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.DateTripDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Slf4j
@Repository
public class DateTripDaoImpl extends DaoImplBase implements DateTripDao {
    @Autowired
    SqlSession sqlSession;

    @Override
    public Integer insertDates(List<Date> dates, int tripId) {
        log.info("DateTripDao insert List<Date> by tripId {}", tripId);
        return getDateTripMapper(sqlSession).insertDates(dates, tripId);
    }

    @Override
    public List<Date> getDatesByTripId(int tripId) {
        log.info("DateTripDao get List<Date> by tripId {}", tripId);
        return getDateTripMapper(sqlSession).getDatesByTripId(tripId);
    }

    @Override
    public Integer deleteByTripId(int tripId) {
        log.info("DateTripDao delete DateTrips by tripId {}", tripId);
        return getDateTripMapper(sqlSession).deleteByTripId(tripId);
    }
}
