package com.mkt.demo.service;

import com.demo.annotation.InTransaction;
import com.demo.annotation.Secured;
import com.demo.ds.CurrencyId;
import org.springframework.stereotype.Component;

@Component("currency") @Secured
public class CurrencyService {


    public int changeCurrency(int amount){
        return amount;
    }
    @InTransaction
    public void changeCurrency(int amount,int transferAmount){

    }

    public String getLongCurrencyName(CurrencyId currencyId){
        if(currencyId.equals(CurrencyId.US)){
            return "USA";
        }
        else throw new IllegalArgumentException();
    }

    public String getLongCountryName(CurrencyId currencyId){
       return switch (currencyId){
            case EURO -> "Euro";
            case US -> "US";
            default -> "Bogus";
        };
    }
}
