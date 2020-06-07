package com.markov.service;

import com.markov.domain.Account;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.List;

public interface IAccountService {
    void saveAccount();
    void updateAccount(Account account);
    int deleteAccount();
    List<Account> findAllAccount();
    Account findAccountByName(String name);

    void transfer(String fromAcctName, String toAcctName, float money);
}
