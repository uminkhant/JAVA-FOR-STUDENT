package com.mkt.demo;

import com.demo.ds.CurrencyId;
import com.demo.service.AccountService;
import com.demo.service.CurrencyService;
import com.demo.service.MyAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        context.registerShutdownHook();

        AccountService accountService=context.getBean(AccountService.class);
        MyAccountService myAccountService=context.getBean(MyAccountService.class);
        CurrencyService currencyService=context.getBean(CurrencyService.class);

        accountService.create();
        myAccountService.create(5000);

        currencyService.changeCurrency(500);
        currencyService.changeCurrency(500,50);
        currencyService.getLongCurrencyName(CurrencyId.US);
        try{
            currencyService.getLongCurrencyName(CurrencyId.EURO);
        }catch (IllegalArgumentException e){
            System.out.println("Exception has been caught.");
        }
        currencyService.getLongCountryName(CurrencyId.US);
        currencyService.getLongCountryName(CurrencyId.EURO);

    }
}
