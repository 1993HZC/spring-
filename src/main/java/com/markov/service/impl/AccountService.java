package com.markov.service.impl;

import com.markov.dao.IAccountDao;
import com.markov.dao.impl.IAccountDaoImpl;
import com.markov.service.IAccountService;

public class AccountService implements IAccountService {
    private IAccountDao accountDao=new IAccountDaoImpl();
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
