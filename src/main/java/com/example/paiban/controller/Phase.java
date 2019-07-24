package com.example.paiban.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.paiban.service.PhaseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@CrossOrigin(value = "*")
public class Phase {
    @Autowired
    private PhaseSer phaseSer;

    @RequestMapping(value = "/insertPhase")
    public JSONObject insertPhase(@RequestParam("Phase") String phase,@RequestParam("hour") int hour){

        JSONObject jsonObject = new JSONObject();
        try {
            phaseSer.insertPhase(phase,hour);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        jsonObject.put("Res","true");
        return jsonObject;
    }

    @RequestMapping(value = "/delPhase")
    public String delPhase(){
        phaseSer.delPhase();
        return "清除成功！请手动返回";

    }

}
