package com.markov.service.impl;

import com.markov.domain.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

@ComponentScan("com.markov")
public class AccountServiceImplTest {

    private ClassPathXmlApplicationContext cp=new ClassPathXmlApplicationContext("bean.xml");
    private AccountServiceImpl accountService=cp.getBean("accountServiceImpl",AccountServiceImpl.class);

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