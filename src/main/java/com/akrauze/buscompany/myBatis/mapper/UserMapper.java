package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getById(int id);


    @Select("SELECT id, firstname, lastname, patronymic, login, password, userRole" +
            " FROM users WHERE login = #{login}")
    User getByLogin(String login);


    @Insert("INSERT INTO users (firstName, lastName, patronymic, login, password, userRole) VALUES "
            + "(#{user.firstName}, #{user.lastName}, #{user.patronymic}, #{user.login}," +
            " #{user.password}, #{user.userRole})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    Integer     insert(@Param("user")User user);


    @Update("UPDATE ...")
    User update();


    @Delete("DELETE ...")
    User delete();
}
