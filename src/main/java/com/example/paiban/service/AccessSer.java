package com.example.paiban.service;

import com.example.paiban.dao.AccessDao;
import com.example.paiban.entity.register;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessSer {
    @Autowired
    AccessDao accessDao;
    public boolean loginquery(String username,String password){

        String md5 = new Md5Hash(password).toString();
        System.out.println(md5);
        if(accessDao.loginquery(username).getPassword().equals(md5)){
            return true;
        }
        return false;
    }

    public boolean updateToken(String token,String username){
        return accessDao.update(token,username);
    }

    public boolean valToken(String reqToken,String reqUsername){

        if(reqToken.equals(accessDao.tokenVal(reqUsername))){
            return true;
        }
        return false;
    }

    public int queryLock(String username){
        return accessDao.lockquery(username).getMylock();
    }

    public int queryRetry(String username){
        return accessDao.retryquery(username).getRetry();
    }

    public boolean updateLock(int lock,String username){
        return accessDao.updateLock(lock,username);
    }

    public boolean updateRetry(String username){
        return accessDao.updateRetry(username);
    }
}
