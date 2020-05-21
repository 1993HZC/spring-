package com.markov.service.impl;

import com.markov.dao.IAccountDao;
import com.markov.dao.impl.IAccountDaoImpl1;
import com.markov.domain.Account;
import com.markov.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AccountService implements IAccountService {

    @Autowired
    @Qualifier("IAccountDaoImpl1")
//    @Resource()
    private IAccountDaoImpl1 accountDao;


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
}
