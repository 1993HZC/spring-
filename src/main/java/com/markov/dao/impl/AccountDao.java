package com.markov.dao.impl;

import com.markov.dao.IAccountDao;
import com.markov.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao implements IAccountDao {
    //    xml使用set方法注
    @Autowired
    private QueryRunner runner;

    @Override
    public void saveAccount(Account acct) {
        System.out.println("Dao111111执行成功");
        try {
            runner.update("insert into account(name,money)values(?,?)",acct.getName(), acct.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
