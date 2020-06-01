package com.markov.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    public void printLog(){
        System.out.println("Logger执行");
    }
    public void afterReturnLog(){System.out.println("Logger正常完成执行afterLog");}
    public void throwingPrintLog(){System.out.println("Logger异常执行");}
    public void finallyLog(){System.out.println("finally执行");}

    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue= null;
        try{
            Object args[]=proceedingJoinPoint.getArgs();
            System.out.println("这也叫前置通知");
            returnValue=proceedingJoinPoint.proceed(args);
            System.out.println("这也叫后置通知");
            return returnValue;
        }catch (Throwable t){
            System.out.println("这也叫异常通知");
            throw new RuntimeException(t);

        }finally {

            System.out.println("这也叫最终通知");

        }

    }
}
