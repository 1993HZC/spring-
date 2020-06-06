package com.markov.service.impl;

import com.markov.service.IAccountService;
import com.markov.service.impl.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String args[]){
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        //这个aop只认接口类型不认AccountService类型
        IAccountService accountService=(IAccountService)ac.getBean("accountService");
        accountService.saveAccount();
        accountService.deleteAccount();
        accountService.updateAccount(1);
        System.out.println(accountService.findAllAccount());
    }
}
