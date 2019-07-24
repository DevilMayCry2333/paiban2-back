package com.example.paiban.service;

import com.example.paiban.controller.Access;
import com.example.paiban.controller.Phase;
import com.example.paiban.dao.PhaseDao;
import com.example.paiban.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PhaseSer {
    private static final Logger logger = LoggerFactory.getLogger(Phase.class);
    @Autowired
    private PhaseDao phaseDao;

    public boolean insertPhase(String beginTime,int hour) throws ParseException {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String initDate = dateFormat.format( now );
        logger.info(initDate);
        Date next = DateUtil.getNextWeekMonday(now);
        String nextDate = dateFormat.format(next);
        logger.info(nextDate);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date dateMor = sdf.parse(beginTime);
        long afterMor = dateMor.getTime()/1000 + hour*3600;
        dateMor.setTime(afterMor*1000);

        phaseDao.insertPhase(beginTime,hour,1,nextDate,initDate,"1",sdf.format(dateMor));

        return true;
    }

    public boolean delPhase(){
        return phaseDao.delPhase();
    }
}
