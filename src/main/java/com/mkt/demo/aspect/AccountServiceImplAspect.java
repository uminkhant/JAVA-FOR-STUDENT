package com.mkt.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class AccountServiceImplAspect {

    //we are using with interface ,so proxy is jdk dynamic proxy.

    //jdk dynamic proxy is working with interface
   // @Pointcut("this(com.mkt.demo.service.AccountService)")

    //jdk dynamic poxy is using with (this) and impl class is using (target)

    @Pointcut("target(com.mkt.demo.service.AccountServiceImpl)")
    public void thisPointcutAccountService(){

    }

    @Before("thisPointcutAccountService()")
    public void beforeAccountServiceAdvice(JoinPoint joinPoint){

        System.out.println(joinPoint.getTarget().getClass() .getSimpleName());
        System.out.println("%s method is invoked with before advice in [%s].".formatted(joinPoint.getSignature().getName(), LocalDateTime.now()));
    }
}
