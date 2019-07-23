package com.example.paiban.service;

import com.example.paiban.controller.Access;
import com.example.paiban.controller.Phase;
import com.example.paiban.dao.PhaseDao;
import com.example.paiban.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PhaseSer {
    private static final Logger logger = LoggerFactory.getLogger(Phase.class);
    @Autowired
    private PhaseDao phaseDao;

    public boolean insertPhase(String beginTime,int hour){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String initDate = dateFormat.format( now );
        logger.info(initDate);
        Date next = DateUtil.getNextWeekMonday(now);
        String nextDate = dateFormat.format(next);
        logger.info(nextDate);

        phaseDao.insertPhase(beginTime,hour,1,initDate,nextDate,"1");

        return true;
    }
}
