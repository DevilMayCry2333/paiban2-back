package com.example.paiban.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("createClassDao")
public interface CreateClassDao {

    @Insert("INSERT INTO classData(phaseId,departId,Today,spaceMor,userId,leftSpaceMor,userNameMor,phaseMor,hourMor,phaseAft,spaceAft,leftSpaceAft,userNameAft,hourAft) VALUES(#{phaseId} , #{departId} , #{Today} , #{spaceMor} , #{userId} , #{leftSpaceMor} , #{userNameMor} , #{phaseMor} , #{hourMor} , #{phaseAft}, #{spaceAft} , #{leftSpaceAft} , #{userNameAft} , #{hourAft})")
    boolean insertClass(@Param("phaseId") int phaseId, @Param("departId") int departId, @Param("Today") String today, @Param("spaceMor") int spaceMor, @Param("userId") String userId, @Param("leftSpaceMor") int leftSpaceMor, @Param("userNameMor") String userNameMor, @Param("phaseMor") String phaseMor, @Param("hourMor") int hourMor, @Param("phaseAft") String phaseAft, @Param("spaceAft") int spaceAft, @Param("leftSpaceAft") int leftSpaceAft, @Param("userNameAft") String userNameAft, @Param("hourAft") int hourAft);


}
