package com.example.paiban.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.paiban.dao.ShowClassDao;
import com.example.paiban.entity.classdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ShowClassSer {
    @Autowired
    private ShowClassDao showClassDao;

    public JSONArray showClass(String departId){
        ArrayList<classdata> arrayList = showClassDao.showclass(departId);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                Date dateMor = sdf.parse(arrayList.get(i).getPhaseMor());
                long afterMor = dateMor.getTime()/1000 + arrayList.get(i).getHourMor()*3600;
                dateMor.setTime(afterMor*1000);
                arrayList.get(i).setPhaseMorEnd(sdf.format(dateMor));

                Date dateAft = sdf.parse(arrayList.get(i).getPhaseAft());
                long afterAft = dateAft.getTime()/1000 + arrayList.get(i).getHourAft()*3600;
                dateAft.setTime(afterAft*1000);
                arrayList.get(i).setPhaseAftEnd(sdf.format(dateAft));

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        String ser = JSON.toJSONString(arrayList);
        return JSON.parseArray(ser);

    }
}
