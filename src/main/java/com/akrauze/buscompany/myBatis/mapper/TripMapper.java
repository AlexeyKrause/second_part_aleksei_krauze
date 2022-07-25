package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.Trip;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TripMapper {
    @Insert("INSERT INTO trips (busId, fromStation, toStation, `start`, duration, price, fromDate, toDate," +
            "period) VALUES(#{trip.busId}, #{trip.fromStation}, #{trip.toStation}, #{trip.start}, " +
            "#{trip.duration}, #{trip.price}, #{trip.schedule.fromDate}, #{trip.schedule.toDate}, " +
            "#{trip.schedule.period})")
    @Options(useGeneratedKeys = true, keyProperty = "trip.id")
    Integer insert(@Param("trip") Trip trip);
}
