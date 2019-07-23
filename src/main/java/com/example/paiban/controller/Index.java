package com.example.paiban.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @RequestMapping(value = "/")
    public String hello(){
        return "hello";
    }
}
