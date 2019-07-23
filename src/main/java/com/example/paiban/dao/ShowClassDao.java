package com.example.paiban.dao;

import com.example.paiban.entity.classdata;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("showClassDao")
public interface ShowClassDao {

    @Select("SELECT * FROM classData WHERE departId = #{departId} ")
    public ArrayList<classdata> showclass(@Param("departId") String departId);
}
