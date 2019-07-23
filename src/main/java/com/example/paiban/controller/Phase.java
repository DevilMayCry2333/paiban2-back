package com.example.paiban.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.paiban.service.PhaseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class Phase {
    @Autowired
    private PhaseSer phaseSer;

    @RequestMapping(value = "/insertPhase")
    public JSONObject insertPhase(@RequestParam("Phase") String phase,@RequestParam("hour") int hour){

        JSONObject jsonObject = new JSONObject();
        phaseSer.insertPhase(phase,hour);

        jsonObject.put("Res","true");
        return jsonObject;
    }

}
