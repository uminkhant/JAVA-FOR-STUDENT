package com.mkt.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class MyAccountServiceAspect {

    //using cjlib proxy
    // same with this and target in cjlib proxy

    @Pointcut("this(com.mkt.demo.service.MyAccountService)")
    public void thisMyAccountServicePoinCut(){

    }

    @Before("thisMyAccountServicePoinCut()")
    public void beforeMyAccountAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget().getClass() .getSimpleName());
        System.out.println("%s method is invoked with %s parameter before advice in [%s]."
                .formatted(joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()), LocalDateTime.now()));
    }
}
