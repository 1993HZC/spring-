package com.markov.service.impl;

import com.markov.service.IAccountService;
import org.aspectj.lang.ProceedingJoinPoint;

public class AccountService implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存账户");

    }

    @Override
    public void updateAccount(int i) {
        System.out.println("升级账户");

    }

    @Override
    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
//    环绕通知固定用法 ProceedingJoinPoint固定参数
}
