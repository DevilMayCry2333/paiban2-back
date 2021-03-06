package com.example.paiban.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.paiban.controller.Access;
import com.example.paiban.dao.SelClassDao;
import com.example.paiban.entity.classdata;
import com.example.paiban.entity.phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SelClassSer {
    private static final Logger logger = LoggerFactory.getLogger(SelClassSer.class);
    @Autowired
    private SelClassDao selClassDao;

    public JSONArray queryClassData(String username){
        ArrayList<classdata> arrayList = selClassDao.queryClassData();

        for (int i = 0; i < arrayList.size(); i++) {

            if(arrayList.get(i).getUserNameMor().contains(username)){
                arrayList.get(i).setAlreadyOrderMor(true);
            }else {
                arrayList.get(i).setAlreadyOrderMor(false);
            }

            if(arrayList.get(i).getUserNameAft().contains(username)){
                arrayList.get(i).setAlreadyOrderAft(true);
            }else {
                arrayList.get(i).setAlreadyOrderAft(false);
            }
        }

        String ser = JSON.toJSONString(arrayList);
        return JSON.parseArray(ser);

    }

    public JSONArray queryPhaseData(){

        ArrayList<phase> arrayList = selClassDao.queryPhaseData();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setText(arrayList.get(i).getPhase() + "-" + arrayList.get(i).getPhaseEnd());
        }

        String ser = JSON.toJSONString(arrayList);
        return JSON.parseArray(ser);

    }

    public boolean orderMorClass(String id,String username,String today){

        if(selClassDao.queryLeftMor(today).getLeftSpaceMor() >= 0){
            classdata cl = selClassDao.queryMorUserById(id);
            String tmpuser = cl.getUserNameMor();
            tmpuser = tmpuser + "," + username;
            selClassDao.updateleftSpaceMor(id);
            return selClassDao.updateMorClass(tmpuser, id);
        }
        return false;
    }

    public boolean orderAftClass(String id,String username,String today){

        if(selClassDao.queryLeftAft(today).getLeftSpaceAft() >= 0){
            classdata cl = selClassDao.queryAftUserById(id);
            String tmpuser = cl.getUserNameAft();
            tmpuser = tmpuser + "," + username;
            selClassDao.updateleftSpaceAft(id);
            return selClassDao.updateAftClass(tmpuser, id);
        }
        return false;
    }

    public boolean cancelMorClass(String id,String username,String today){
        classdata cl = selClassDao.queryMorUserById(id);
        String tmpUser = cl.getUserNameMor();
        String []tmpSpilt = tmpUser.split(',' + username);
        String tmp = "";
        for (int i = 0; i < tmpSpilt.length; i++) {
            tmp += tmpSpilt[i];
        }
        logger.info(tmp);
        if(selClassDao.cancelleftSpaceMor(id)){
            return selClassDao.updateMorClass(tmp,id);
        }
        return false;
    }

    public boolean cancelAftClass(String id,String username,String today){
        classdata cll = selClassDao.queryAftUserById(id);
        String tmpUser = cll.getUserNameAft();
        String []tmpSpilt = tmpUser.split(',' + username);
        String tmp = "";
        for (int i = 0; i < tmpSpilt.length; i++) {
            tmp += tmpSpilt[i];
        }
        logger.info(tmp);
        if(selClassDao.cancelleftSpaceAft(id)){
            return selClassDao.updateAftClass(tmp,id);
        }
        return false;
    }

    public boolean delClass(){
        return selClassDao.delClass();
    }
}
