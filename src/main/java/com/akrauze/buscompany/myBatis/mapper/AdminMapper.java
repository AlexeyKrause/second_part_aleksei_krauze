package com.akrauze.buscompany.myBatis.mapper;


import com.akrauze.buscompany.model.Admin;
import com.akrauze.buscompany.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface AdminMapper {

    @Insert("INSERT INTO admins (position, userId) VALUES "
            + "(#{admin.position}, #{admin.user.id})")
    @Options(useGeneratedKeys = true, keyProperty = "admin.id")
    Integer insert(@Param("admin") Admin admin);


    @Select("SELECT id, position, userId FROM admins WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "com.akrauze.buscompany.myBatis.mapper.UserMapper.getById", fetchType = FetchType.LAZY)),
            @Result(property = "position", column = "position")
    })
    Admin getById(int id);
}
