package com.akrauze.buscompany.myBatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PeriodsTrip {

    @Select("SELECT * FROM periodsTrip WHERE tripId=#{tripId}")
    List<String> getPeriodsByTripId(@Param("tripId") int tripId);
}
