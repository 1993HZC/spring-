package com.markov.proxy;

import com.markov.service.IAccountService;
import com.markov.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    //这个final添加很怪异
    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService(){

        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue=null;
                        try{
                            //开启事务
                            transactionManager.beginTransaction();
                            //执行操作
                            returnValue=method.invoke(accountService,args);

                            //提交事务
                            transactionManager.commit();
                            //返回结果
                            return returnValue;
                        }catch (Exception e){
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            transactionManager.release();
                        }
                    }
                });
    }


}
