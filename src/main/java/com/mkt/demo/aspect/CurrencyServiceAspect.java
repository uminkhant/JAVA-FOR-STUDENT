package com.mkt.demo.aspect;

import com.mkt.demo.annotation.Secures;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Secures
public class CurrencyServiceAspect {

    @Pointcut("within(com.mkt.demo.service.*)")
    public void withinCurrencyServicePointCut(){

    }

    @Pointcut("@within(com.mkt.demo.annotation.Secures)")
    public void withinAnnotationCurrencyServicePointCut(){

    }

    @Before("withinAnnotationCurrencyServicePointCut()")
    public void beforeCurrencyServiceAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget().getClass() .getSimpleName());
        System.out.println("%s method is invoked with before advice in [%s].".formatted(joinPoint.getSignature().getName(), LocalDateTime.now()));
    }

    @Before("withinCurrencyServicePointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget().getClass() .getSimpleName());
        System.out.println("%s method is invoked with before advice in [%s].".formatted(joinPoint.getSignature().getName(), LocalDateTime.now()));
    }

}
