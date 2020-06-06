package com.markov.dao;

import com.markov.domain.Account;

import java.util.List;

public interface IAccountDao {

    void saveAccount(Account acct);

    List<Account> findAllAccount();
}
