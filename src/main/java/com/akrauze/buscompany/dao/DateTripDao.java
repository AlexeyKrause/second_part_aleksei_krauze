package com.akrauze.buscompany.dao;


import java.util.Date;
import java.util.List;

public interface DateTripDao {
    Integer insertDates(List<Date> dates, int tripId);

    List<Date> getDatesByTripId(int tripId);

    Integer deleteByTripId(int tripId);
}
