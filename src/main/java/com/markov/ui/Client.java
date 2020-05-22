package com.markov.ui;

import com.markov.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String args[]){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
//        accountService.saveAccount();
    }
}
