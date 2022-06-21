package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.Client;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * " +
            "FROM users WHERE id = #{id}")
    void getById(int id);


    @Select("SELECT id " +
            "FROM users WHERE login = #{login}")
    int getIdByLogin(String login);


    @Select("SELECT password " +
            "FROM users WHERE login = #{login}")
    String getPassByLogin(String login);


    @Select("SELECT userRole " +
            "FROM users WHERE login = #{login}")
    String getUserRoleByLogin(String login);


    @Insert("INSERT INTO users (firstName, lastName, patronymic, login, password, userRole) VALUES "
            + "(#{admin.firstName}, #{admin.lastName}, #{admin.patronymic}, #{admin.login}," +
            " #{admin.password}, #{admin.userRole})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    Integer insertFromAdmin(@Param("admin") Admin admin);


    @Insert("INSERT INTO users (firstName, lastName, patronymic, login, password, userRole) VALUES "
            + "(#{client.firstName}, #{client.lastName}, #{client.patronymic}, #{client.login}," +
            " #{client.password}, #{client.userRole})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    Integer insertFromClient(@Param("client") Client client);


//    @Update("UPDATE ...")
//    User update();
//
//
//    @Delete("DELETE ...")
//    User delete();
}
