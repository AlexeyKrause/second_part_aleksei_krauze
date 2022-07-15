package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.Bus;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BusMapper {
    @Select("SELECT * FROM buses")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "busName", column = "busName"),
            @Result(property = "placeCount", column = "placeCount")
    })
    List<Bus> getAll();

    @Select("SELECT * FROM buses WHERE buses.busName=#{busName}")
    Bus getByName(@Param("busName") String busName);
}
