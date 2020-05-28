package com.markov.service.impl;

import com.markov.dao.IAccountDao;
import com.markov.domain.Account;
import com.markov.service.IAccountService;
import com.markov.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl_OLD implements IAccountService{

    private IAccountDao accountDao;
    private TransactionManager transactionManager;


    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try{
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //提交事务
            transactionManager.commit();
            //返回结果
            return accounts;
        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            Account account=accountDao.findAccountById(accountId);
            //提交事务
            transactionManager.commit();
            //返回结果
            return account;
        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            accountDao.saveAccount(account);
            //提交事务
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            accountDao.updateAccount(account);
            //提交事务
            transactionManager.commit();

        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        try{
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            accountDao.deleteAccount(acccountId);
            //提交事务
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }
    @Override
    public void transfer(String fromAcctName, String  toAcctName, Integer money) {
        try{
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            Account fromAcct=accountDao.findAcctByName(fromAcctName);
            Account toAccct=accountDao.findAcctByName(toAcctName);
            fromAcct.setMoney(fromAcct.getMoney()-money);
            toAccct.setMoney(toAccct.getMoney()+money);
            accountDao.updateAccount(fromAcct);
            int i=1/0;
            accountDao.updateAccount(toAccct);
            //提交事务
            transactionManager.commit();
            //返回结果
        }catch (Exception e){
            transactionManager.rollback();
//            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

}
