package com.mkt.demo;

import com.mkt.demo.ds.CurrencyId;
import com.mkt.demo.service.AccountService;
import com.mkt.demo.service.CurrencyService;
import com.mkt.demo.service.MyAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        context.registerShutdownHook();

        AccountService accountService=context.getBean(AccountService.class);
        MyAccountService myAccountService=context.getBean(MyAccountService.class);
        CurrencyService currencyService=context.getBean(CurrencyService.class);

        currencyService.changeCurrency(500);
        currencyService.getChangeCurrency(500,50);
        currencyService.getLongCurrencyName(CurrencyId.US);

        try{
            currencyService.getLongCurrencyName(CurrencyId.EURO);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

       // accountService.create();
        //myAccountService.create(5000);
    }
}
