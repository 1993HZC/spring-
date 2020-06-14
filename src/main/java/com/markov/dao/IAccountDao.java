package com.markov.dao;

import com.markov.domain.Account;

import java.util.List;

public interface IAccountDao {

    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);
}
