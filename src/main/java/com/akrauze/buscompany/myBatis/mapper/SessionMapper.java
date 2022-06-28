package com.akrauze.buscompany.myBatis.mapper;


import com.akrauze.buscompany.model.Session;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SessionMapper {
    @Insert("INSERT INTO sessions (userId, javaSessionId) VALUES(#{session.userId}, #{session.javaSessionId})")
    @Options(useGeneratedKeys = true, keyProperty = "session.id")
    Integer insert(@Param("session") Session session);

    @Select("SELECT * FROM sessions WHERE userId=#{userId}")
    Session getByUserId(int userId);

    @Delete("DELETE ")
    void delete();

    @Update("UPDATE sessions SET isActive = #{session.isActive}, javaSessionId = #{session.javaSessionId} " +
            "WHERE userId = #{session.userId}")
    Session updateSession(@Param("session") Session session);

//    @Update("")
//    Session updateIsActive
}
