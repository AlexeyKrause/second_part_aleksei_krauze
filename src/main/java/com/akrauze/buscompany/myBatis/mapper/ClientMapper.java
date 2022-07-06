package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.Client;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Insert("INSERT INTO clients (email, phoneNumber, userId) VALUES "
            + "(#{client.email}, #{client.phoneNumber}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "client.id")
    Integer insert(@Param("client") Client client, @Param("userId") int userId);


    @Select("SELECT clients.id AS id, clients.email AS email, clients.phoneNumber AS phoneNumber,clients.userId AS userId, " +
            "users.firstName AS firstName, users.lastname AS lastName, users.patronymic AS patronymic, users.login AS login, " +
            "users.password AS password, users.userRole AS userRole " +
            "FROM clients, users " +
            "WHERE clients.id = #{id} AND users.id = userId")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "patronymic", column = "patronymic"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "userRole", column = "userRole"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phoneNumber"),
    })
    Client getById(int id);


    @Select("SELECT clients.id AS id, clients.email AS email, clients.phoneNumber AS phoneNumber,clients.userId AS userId, " +
            "users.firstName AS firstName, users.lastname AS lastName, users.patronymic AS patronymic, users.login AS login, " +
            "users.password AS password, users.userRole AS userRole " +
            "FROM clients JOIN users ON users.id=userId AND users.login=#{login}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "patronymic", column = "patronymic"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "userRole", column = "userRole"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phoneNumber"),
    })
    Client getByLogin(String login);


    @Select("SELECT clients.id AS id, clients.email AS email, clients.phoneNumber AS phoneNumber,clients.userId AS userId, " +
            "users.firstName AS firstName, users.lastname AS lastName, users.patronymic AS patronymic, users.login AS login, " +
            "users.password AS password, users.userRole AS userRole " +
            "FROM clients " +
            "JOIN users ON users.id = clients.userId " +
            "JOIN sessions ON sessions.userId = clients.userId " +
            "WHERE sessions.javaSessionId=#{javaSessionId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "patronymic", column = "patronymic"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "userRole", column = "userRole"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phoneNumber"),
    })
    Client getByJavaSessionId(String javaSessionId);


    @Select("SELECT clients.id AS id, clients.email AS email, clients.phoneNumber AS phoneNumber,clients.userId AS userId, " +
            "users.firstName AS firstName, users.lastname AS lastName, users.patronymic AS patronymic, users.login AS login, " +
            "users.password AS password, users.userRole AS userRole " +
            "FROM clients INNER JOIN users ON users.id = userId")
    @Results(value = {
                @Result(property = "id", column = "id"),
                @Result(property = "firstName", column = "firstName"),
                @Result(property = "lastName", column = "lastName"),
                @Result(property = "patronymic", column = "patronymic"),
                @Result(property = "login", column = "login"),
                @Result(property = "password", column = "password"),
                @Result(property = "userRole", column = "userRole"),
                @Result(property = "email", column = "email"),
                @Result(property = "phoneNumber", column = "phoneNumber"),
    })
    List<Client> getAll();


    @Update("UPDATE clients SET email = #{client.email}, phoneNumber = #{client.phoneNumber} " +
            "WHERE userId = #{userId}")
    void update(@Param("client") Client client, @Param("userId") int userId);


    @Delete("DELETE ...")
    Client delete();

    @Delete(("DELETE "))
    void deleteAll();
}