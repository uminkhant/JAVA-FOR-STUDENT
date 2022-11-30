package com.mkt.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MyAccountService {

   public void create(int amount){
        System.out.println("My account service with ::"+amount);
    }
}
