package com.example.paiban.controller;

import com.example.paiban.service.CreateClassSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class CreateClass {
    @Autowired
    private CreateClassSer createClassSer;

    @RequestMapping(value = "/createClass")
    public String createClass(){

        try {
            createClassSer.create(5);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "生成成功，请手动返回!";
    }
}
