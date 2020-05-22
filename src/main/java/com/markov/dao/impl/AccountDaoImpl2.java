package com.markov.dao.impl;


import com.markov.dao.IAccountDao;
import com.markov.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount(){
        System.out.println("DAO2222执行成功");
    }

    @Override
    public void saveAccount(Account acct) {

    }

    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer accountId) {

    }
}
