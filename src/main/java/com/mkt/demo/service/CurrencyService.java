package com.mkt.demo.service;

import com.mkt.demo.ds.CurrencyId;
import org.springframework.stereotype.Component;

@Component
public class CurrencyService {

    public int changeCurrency(int amount){
        return amount;
    }

    public void changeCurrency(int amount,int transferAmount){

    }

    public String getLongCurrencyName(CurrencyId currencyId){
        if(currencyId.equals(CurrencyId.US)){
            return "USA";
        }else throw  new IllegalArgumentException();

    }

    public String getLongCountryName(CurrencyId currencyId){
       return  switch (currencyId){
            case EURO -> "Euro";
           case US -> "America";
           default -> "Bogus";
        };
    }

    public void getChangeCurrency(int i, int i1) {

    }
}
