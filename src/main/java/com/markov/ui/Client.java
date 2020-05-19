package com.markov.ui;

import com.markov.service.IAccountService;
import com.markov.service.impl.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String args[]){
//        IAccountService accountService= new AccountService();
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
//        ac.getBean("accountDaos");
        accountService.saveAccount();
    }
}
