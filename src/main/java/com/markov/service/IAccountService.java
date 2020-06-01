package com.markov.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IAccountService {
    void saveAccount();
    void updateAccount(int i);
    int deleteAccount();

}
