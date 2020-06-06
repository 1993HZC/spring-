package com.markov.service;

import com.markov.domain.Account;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.List;

public interface IAccountService {
    void saveAccount();
    void updateAccount(int i);
    int deleteAccount();
    List<Account> findAllAccount();

}
