package com.example.paiban.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.paiban.service.AccessSer;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(value = "*")
public class Access {
    @Autowired
    private AccessSer accessSer;

    private static final Logger logger = LoggerFactory.getLogger(Access.class);
    @RequestMapping(value = "/login")
    public JSONObject login(@RequestParam String username,@RequestParam String password){
        logger.info(username);
        logger.info(password);
        String md5 = new Md5Hash(username + password + System.currentTimeMillis()).toString();
        logger.info(md5);
        JSONObject jsonObject = new JSONObject();
        if (accessSer.loginquery(username,password)){
            accessSer.updateToken(md5,username);
        }

        jsonObject.put("Res",accessSer.loginquery(username,password));
        jsonObject.put("Token",md5);
        return jsonObject;

    }


}
