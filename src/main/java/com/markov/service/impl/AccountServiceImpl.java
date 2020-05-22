package com.markov.service.impl;

import com.markov.dao.impl.AccountDaoImpl1;
import com.markov.domain.Account;
import com.markov.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("IAccountDaoImpl1")
//    @Resource()
    @Autowired
    private AccountDaoImpl1 accountDao;


    @Override
    public void saveAccount(Account acct) {
        accountDao.saveAccount(acct);
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
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);

    }

    public void setAccountDaoImpl1(AccountDaoImpl1 accountDaoImpl1) {
        this.accountDao = accountDaoImpl1;
    }

    public AccountDaoImpl1 getAccountDaoImpl1() {
        return accountDao;
    }
}
