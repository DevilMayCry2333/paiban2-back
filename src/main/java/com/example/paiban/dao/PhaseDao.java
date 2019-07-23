package com.example.paiban.dao;

import com.example.paiban.entity.phase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("phaseDao")
public interface PhaseDao {
    @Insert("INSERT INTO phase(phase,departId,hour,createDate,initDate,phaseId) VALUES(#{phase},#{departId},#{hour},#{createDate},#{initDate},#{phaseId})")
    boolean insertPhase(@Param("phase") String phase,@Param("hour") int hour,@Param("departId") int departId,@Param("initDate") String initDate,@Param("createDate") String createDate,@Param("phaseId") String phaseId);

    @Select("SELECT * FROM phase WHERE departId= #{departId}")
    ArrayList<phase> selectPhase(@Param("departId") int departId);

}
