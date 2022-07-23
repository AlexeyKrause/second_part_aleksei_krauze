package com.akrauze.buscompany.myBatis.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface DatesTripMapper {
    @Insert({"<script>",
                "INSERT INTO datesTrip (`date`, tripId) VALUES",
                "<foreach item='item' collection='list' separator=','>",
                "( #{item.date}, #{tripId} )",
                "</foreach>",
                "</script>"})
    Integer insert(@Param("list")List<String> dates, @Param("tripId") int tripId);


    @Select("SELECT FROM datesTrip WHERE tripId = #{tripId}")
    List<Date> getDatesByTripId(@Param("tripId") int tripId);


    @Delete("DELETE FROM datesTrip WHERE tripId = #{tripId}")
    Integer deleteByTripId(@Param("tripId") int tripId);


}
