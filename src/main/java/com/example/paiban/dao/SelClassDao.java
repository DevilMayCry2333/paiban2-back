package com.example.paiban.dao;

import com.example.paiban.entity.classdata;
import com.example.paiban.entity.phase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("selClassDao")
public interface SelClassDao {

    @Select("SELECT * FROM classData")
    ArrayList<classdata> queryClassData();

    @Select("SELECT * FROM phase")
    ArrayList<phase> queryPhaseData();

    //这个方法在选班的时候要用到
    @Select("SELECT usernameMor FROM classData WHERE id= #{id}")
    classdata queryMorUserById(@Param("id") String id);

    @Select("SELECT usernameAft FROM classData WHERE id= #{id}")
    classdata queryAftUserById(@Param("id") String id);

    @Update("UPDATE classData SET usernameMor= #{usernameMor} WHERE id= #{id}")
    boolean updateMorClass(@Param("usernameMor") String usernameMor, @Param("id") String id);

    @Update("UPDATE classData SET usernameAft= #{usernameAft} WHERE id= #{id}")
    boolean updateAftClass(@Param("usernameAft") String usernameAft, @Param("id") String id);

    @Update("UPDATE classData SET leftSpaceMor = leftSpaceMor - 1 WHERE id= #{id}")
    boolean updateleftSpaceMor(@Param("id") String id);

    @Update("UPDATE classData SET leftSpaceAft = leftSpaceAft - 1 WHERE id= #{id}")
    boolean updateleftSpaceAft(@Param("id") String id);

    //TODO: 要写查询早上人次和下午人次的
    @Select("SELECT leftSpaceMor FROM classData WHERE Today = #{today}")
    classdata queryLeftMor(@Param("today") String today);

    @Select("SELECT leftSpaceAft FROM classData WHERE Today = #{today}")
    classdata queryLeftAft(@Param("today") String today);


}
