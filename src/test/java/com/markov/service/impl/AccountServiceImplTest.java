package com.markov.service.impl;

import com.markov.config.Config;
import com.markov.dao.impl.AccountDaoImpl1;
import com.markov.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
//纯注解配置使用ContextConfiguration
//要使用location=xml路径
@ContextConfiguration(classes = Config.class)
public class AccountServiceImplTest {

//    Junit不能正常使用autowired
////    private ClassPathXmlApplicationContext cp=new ClassPathXmlApplicationContext("bean.xml");
//    private AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
//    private AccountServiceImpl accountService=ac.getBean("accountServiceImpl",AccountServiceImpl.class);

    @Autowired
    private AccountServiceImpl accountService;

    @Test
    public void saveAccount() {
        Account account=new Account();
        account.setMoney((float) 99999);
        account.setName("yyy");
        account.setId(10);
        accountService.saveAccount(account);
    }

    @Test
    public void findAllAccount() {
        List<Account>accountList= accountService.findAllAccount();
        for (Account account :accountList){
            System.out.println(account);
        }
    }

    @Test
    public void findAccountById() {
        Account account= accountService.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void updateAccount() {
        Account account=new Account();
        account.setMoney((float) 99999);
        account.setName("ooo");
        account.setId(2);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount() {

    }
}