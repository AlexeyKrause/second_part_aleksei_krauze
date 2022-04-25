package com.akrauze.buscompany.mapper;

import com.akrauze.buscompany.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT id, name FROM test WHERE id = #{id}")
    User getById(int id);



    @Insert("INSERT INTO test (name) VALUES "
            + "( #{user.name} )")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    Integer insert(@Param("user")User user);
}
