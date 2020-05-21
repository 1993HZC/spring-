package com.markov.ui;

import com.markov.service.IAccountService;
import com.markov.service.impl.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import javax.xml.bind.annotation.XmlAccessOrder;

public class Client {
    public static void main(String args[]){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=ac.getBean("accountService",IAccountService.class);
        accountService.saveAccount();
    }
}
