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
    Integer getIdByLogin(String login);


    @Select("SELECT password " +
            "FROM users WHERE login = #{login}")
    String getPassByLogin(String login);


    @Select("SELECT userRole " +
            "FROM users WHERE login = #{login}")
    String getUserRoleByLogin(String login);

    @Select("SELECT users.userRole " +
            "FROM users, sessions " +
            "WHERE javaSessionId = #{javaSessionId} AND users.id=sessions.userId")
    String getUserRoleByJavaSessionId(String javaSessionId);

    @Select("SELECT COUNT(*) FROM users WHERE login = #{login}")
    int getCountLogin(String login);


    @Insert("INSERT INTO users (firstName, lastName, patronymic, login, password, userRole) VALUES "
            + "(#{admin.firstName}, #{admin.lastName}, #{admin.patronymic}, #{admin.login}," +
            " #{admin.password}, #{admin.userRole})")
    @Options(useGeneratedKeys = true) //, keyProperty = "user.id"
    Integer insertFromAdmin(@Param("admin") Admin admin);


    @Insert("INSERT INTO users (firstName, lastName, patronymic, login, password, userRole) VALUES "
            + "(#{client.firstName}, #{client.lastName}, #{client.patronymic}, #{client.login}," +
            " #{client.password}, #{client.userRole})")
    @Options(useGeneratedKeys = true)//, keyProperty = "user.id"
    Integer insertFromClient(@Param("client") Client client);


    @Update("UPDATE users SET firstName = #{admin.firstName}, lastName = #{admin.lastName}, patronymic = #{admin.patronymic} " +
            "password = #{admin.password} " +
            "WHERE id = #{admin.userId}")
    void updateFromAdmin(@Param("admin") Admin admin);


//    @Delete("DELETE ...")
//    User delete();

    @Delete("DELETE ")
    void deleteAll();
}
