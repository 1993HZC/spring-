package com.markov.service.impl;

import com.markov.dao.impl.AccountDao;
import com.markov.domain.Account;
import com.markov.service.IAccountService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Scope("prototype")
@Service("accountService")
public class AccountService implements IAccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void saveAccount() {
        System.out.println("保存账户");

    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("更新账户");
        accountDao.updateAccount(account);

    }

    @Override
    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByName(String name) {
        return accountDao.findAccountByName(name);
    }
    @Override
    public void transfer(String fromAcctName,String toAcctName,float money){
        Account fromAcct= this.findAccountByName(fromAcctName);
        Account toAcct=this.findAccountByName(toAcctName);
        fromAcct.setMoney(fromAcct.getMoney()-money);
        toAcct.setMoney(toAcct.getMoney()+money);
        this.updateAccount(fromAcct);
//        int i=1/0;
        this.updateAccount(toAcct);
    }
//    环绕通知固定用法 ProceedingJoinPoint固定参数
}
