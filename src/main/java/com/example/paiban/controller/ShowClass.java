package com.example.paiban.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.paiban.service.ShowClassSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class ShowClass {
    @Autowired
    private ShowClassSer showClassSer;

    @RequestMapping(value = "/showClass")

    public JSONArray showClass(){
        String departId = "1";
        return showClassSer.showClass(departId);
    }

}
