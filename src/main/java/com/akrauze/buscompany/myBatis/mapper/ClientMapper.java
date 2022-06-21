package com.akrauze.buscompany.myBatis.mapper;

import com.akrauze.buscompany.model.Client;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ClientMapper {

    @Insert("INSERT INTO clients (email, telefonNumber, userId) VALUES "
            + "(#{client.email}, #{client.telefonNumber}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "client.id")
    Integer insert(@Param("client") Client client, @Param("userId") int userId);


    @Select("SELECT clients.id AS id, clients.email AS email, clients.telefonNumber AS telefonNumber,clients.userId AS userId, users.firstName AS firstName, " +
            "users.lastname AS lastName, users.patronymic AS patronymic, users.login AS login, users.password AS password, " +
            "users.userRole AS userRole " +
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
            @Result(property = "telefonNumber", column = "telefonNumber"),
    })
    Client getById(int id);


    @Update("UPDATE ...")
    Client update();


    @Delete("DELETE ...")
    Client delete();
}
