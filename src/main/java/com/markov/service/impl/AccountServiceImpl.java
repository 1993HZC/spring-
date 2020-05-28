package com.markov.service.impl;

import com.markov.dao.IAccountDao;
import com.markov.domain.Account;
import com.markov.service.IAccountService;
import com.markov.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
            return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
            //执行操作
            accountDao.deleteAccount(acccountId);
    }
    @Override
    public void transfer(String fromAcctName, String  toAcctName, Integer money) {
            Account fromAcct=accountDao.findAcctByName(fromAcctName);
            Account toAccct=accountDao.findAcctByName(toAcctName);
            fromAcct.setMoney(fromAcct.getMoney()-money);
            toAccct.setMoney(toAccct.getMoney()+money);
            accountDao.updateAccount(fromAcct);
            int i=2/0;
            accountDao.updateAccount(toAccct);
    }

}
