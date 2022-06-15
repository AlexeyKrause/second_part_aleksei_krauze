package com.akrauze.buscompany.myBatis.mapper;


import com.akrauze.buscompany.model.Session;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SessionMapper {
    @Insert("INSERT INTO sessions (userId) VALUES(#{session.userId})")

    @Options(useGeneratedKeys = true, keyProperty = "session.id")
    Integer insert(@Param("session") Session session);

    @Select("SELECT id, isActive, userId FROM sessions WHERE userId=#{id}")
    Session getById(int id);
}
