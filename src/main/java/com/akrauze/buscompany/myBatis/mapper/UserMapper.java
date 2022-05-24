package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getById(int id);


    @Select("SELECT id, firstname, lastname, patronymic, login, password, role, isActiv" +
            " FROM users WHERE login = #{login}")
//@Select("SELECT *" +
//        " FROM users WHERE login = #{login}")
    User getByLogin(String login);


    @Insert("INSERT INTO users (firstName, lastName, patronymic, login, password, role) VALUES "
            + "(#{user.firstName}, #{user.lastName}, #{user.patronymic}, #{user.login}," +
            " #{user.password}, #{user.role})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    Integer insert(@Param("user")User user);
}
