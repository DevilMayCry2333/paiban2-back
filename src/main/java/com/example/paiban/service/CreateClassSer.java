package com.example.paiban.service;

import com.example.paiban.controller.Access;
import com.example.paiban.dao.CreateClassDao;
import com.example.paiban.dao.PhaseDao;
import com.example.paiban.entity.phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CreateClassSer {

    private static final Logger logger = LoggerFactory.getLogger(CreateClassSer.class);
    @Autowired
    private CreateClassDao createClassDao;
    @Autowired
    private PhaseDao phaseDao;

    public boolean create(int iteCount) throws ParseException {
        ArrayList<phase> arrayList = phaseDao.selectPhase(1);

        phase p1 = arrayList.get(0);
        phase p2 = arrayList.get(1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        Date initDate = dateFormat.parse(p1.getInitDate());

        boolean res = true;

        logger.info(initDate.toString());


        long initTime = initDate.getTime()/1000;


        for (int i = 0; i < iteCount; i++) {
            long afterAft = initTime + i*3600*24;
            initDate.setTime(afterAft*1000);
            boolean tmp = createClassDao.insertClass(p1.getPhaseId(),p1.getDepartId(),dateFormat.format(initDate),2,"Test",2,"#",p1.getPhase(),p1.getHour(),p2.getPhase(),2,2,"#",p2.getHour());
            if(!tmp)
                res = false;
        }

        return res;
    }

}
