package com.example.paiban.dao;

import com.example.paiban.entity.register;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository("accessDao")
public interface AccessDao {
    @Select("SELECT password FROM register WHERE username= #{username}")
    register loginquery(@Param("username") String username);

    @Update("UPDATE register SET token = #{token} WHERE username = #{username}")
    boolean update(@Param("token") String token,@Param("username") String username);

    @Select("SELECT token FROM register WHERE username= #{username}")
    register tokenVal(@Param("username") String username);


}
