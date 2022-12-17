package com.web;

import com.alibaba.fastjson.JSON;
import example.userInformation;

public class JSONtrain {

    public static void main(String[] args){
        userInformation users = new userInformation();
        users.setUsername("ssjk");
        users.setId(1);
        users.setPassword("sjakldklsa");
        String q = JSON.toJSONString(users);
        System.out.println(q);
    }
}
