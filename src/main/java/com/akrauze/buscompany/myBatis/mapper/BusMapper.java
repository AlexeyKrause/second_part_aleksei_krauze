package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.Bus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
