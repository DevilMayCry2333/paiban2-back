package com.example.paiban.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.paiban.service.SelClassSer;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")

public class SelClass {
    private static final Logger logger = LoggerFactory.getLogger(SelClass.class);
    @Autowired
    private SelClassSer selClassSer;

    @RequestMapping(value = "/queryClass")
    public JSONArray queryClass(@RequestParam("username") String username){
        logger.info(username);
        return selClassSer.queryClassData(username);
    }

    @RequestMapping(value = "/queryPhase")
    public JSONArray queryPhase(){
        return selClassSer.queryPhaseData();

    }

    @RequestMapping(value = "/orderMorClass")
    public JSONObject orderMorClass(@RequestParam("id") String id,@RequestParam("username") String username,@RequestParam("today") String today){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Res",selClassSer.orderMorClass(id, username,today));
        return jsonObject;

    }

    @RequestMapping(value = "/orderAftClass")
    public JSONObject orderAftClass(@RequestParam("id") String id,@RequestParam("username") String username,@RequestParam("today") String today){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Res",selClassSer.orderAftClass(id,username,today));
        return jsonObject;
    }

    @RequestMapping(value = "/cancelMorClass")
    public JSONObject cancelMorClass(@RequestParam("id") String id,@RequestParam("username") String username,@RequestParam("today") String today){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Res",selClassSer.cancelMorClass(id,username,today));
        return jsonObject;
    }

    @RequestMapping(value = "/cancelAftClass")
    public JSONObject cancelAftClass(@RequestParam("id") String id,@RequestParam("username") String username,@RequestParam("today") String today){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Res",selClassSer.cancelAftClass(id,username,today));
        return jsonObject;
    }

    @RequestMapping(value = "/delClass")
    public String delClass(){
        selClassSer.delClass();
        return "清除成功! 请手动返回";
    }

}
