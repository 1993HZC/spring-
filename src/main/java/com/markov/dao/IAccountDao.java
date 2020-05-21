package com.markov.dao;

import com.markov.domain.Account;

import java.util.List;

public interface IAccountDao {
    void saveAccount(Account acct);
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
}
