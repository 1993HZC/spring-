package com.markov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class ConnectionUtils {
    private ThreadLocal<Connection>tl=new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public Connection getThreadConnection(){
        try{
            Connection conn=tl.get();
            if (conn==null){
                conn=dataSource.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void removeConnection(){
        tl.remove();
    }
}
