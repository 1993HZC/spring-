package com.markov.service;

import com.markov.domain.Account;

import java.util.List;

public interface IAccountService {
    void saveAccount(Account acct);
    List<Account>findAllAccount();
    Account findAccountById(Integer accountId);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
}
