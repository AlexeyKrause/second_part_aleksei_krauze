package com.akrauze.buscompany.myBatis.mapper;


import com.akrauze.buscompany.model.Admin;
import org.apache.ibatis.annotations.*;


@Mapper
public interface AdminMapper {
    @Insert("INSERT INTO admins (position, userId) VALUES "
            + "(#{admin.position}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "admin.id")
    Integer insert(@Param("admin") Admin admin, @Param("userId") int userId);


    @Select("SELECT admins.id AS id, admins.position AS position, admins.userId AS userId, users.firstName AS firstName, " +
            "users.lastname AS lastName, users.patronymic AS patronymic, users.login AS login, users.password AS password, " +
            "users.userRole AS userRole " +
            "FROM admins, users " +
            "WHERE admins.id = #{id} AND users.id=admins.userId")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "patronymic", column = "patronymic"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "userRole", column = "userRole"),
            @Result(property = "position", column = "position")
    })
    Admin getById(int id);


    @Select("SELECT admins.id AS id, admins.position AS position, admins.userId AS userId, users.firstName AS firstName, " +
            "users.lastname AS lastName, users.patronymic AS patronymic, users.login AS login, users.password AS password, " +
            "users.userRole AS userRole " +
            "FROM admins, users " +
            "WHERE users.login=#{login}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "patronymic", column = "patronymic"),
            @Result(property = "login", column = "login"),
            @Result(property = "password", column = "password"),
            @Result(property = "userRole", column = "userRole"),
            @Result(property = "position", column = "position")
    })
    Admin getByILogin(String login);


    @Update("UPDATE ...")
    Admin update();


    @Delete("DELETE ...")
    Admin delete();

    @Delete("DELETE ")
    void deleteAll();
}
