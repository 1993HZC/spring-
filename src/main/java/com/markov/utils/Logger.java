package com.markov.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logger")
/*表示当前类是一个切面类*/
@Aspect
public class Logger {
    @Autowired
    private TransactionManager transactionManager;
//    设置pt1为切面点
    @Pointcut("execution(* com.markov.service.impl.*.*(..))")
    private void pt1(){};
//    @Before("pt1()")
    public void printLog(){
        System.out.println("Logger执行");
    }
//    @AfterReturning("pt1()")
    public void afterReturnLog(){System.out.println("Logger正常完成执行afterLog");}
//    @AfterThrowing("pt1()")
    public void throwingPrintLog(){System.out.println("Logger异常执行");}
//    @After("pt1()")
    public void finallyLog(){System.out.println("finally执行");}
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue= null;
        try{
            Object args[]=proceedingJoinPoint.getArgs();
            System.out.println(transactionManager);
            System.out.println(transactionManager.connectionUtils);
            transactionManager.beginTransaction();
            System.out.println("这也叫前置通知");
            returnValue=proceedingJoinPoint.proceed(args);
            System.out.println(transactionManager);
            System.out.println(transactionManager.connectionUtils);
            transactionManager.commit();
            System.out.println("这也叫后置通知");
            return returnValue;
        }catch (Throwable t){
            System.out.println("这也叫异常通知");
            transactionManager.rollback();
            throw new RuntimeException(t);

        }finally {
            transactionManager.release();
            System.out.println("这也叫最终通知");

        }

    }
}
