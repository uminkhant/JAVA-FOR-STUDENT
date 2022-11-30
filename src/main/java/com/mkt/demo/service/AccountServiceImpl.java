package com.mkt.demo.service;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements  AccountService{
    @Override
    public void create() {
        System.out.println("Account created ::");
    }
}
