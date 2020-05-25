package com.markov.utils;

public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
    /**
    * 开启事务
    * */
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     * */
    public void commit(){
        try{
            connectionUtils.getThreadConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollback(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void release(){
        try{
//            还会连接池
            connectionUtils.getThreadConnection().close();
//            解绑
            connectionUtils.removeConnection();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}