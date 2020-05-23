package com.markov.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
public class JDBCconfig {

    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.Url}")
    private String  JdbcUrl;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name="runner")
    @Scope("prototype")
    public QueryRunner createRunner(ComboPooledDataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource(){
        try {
            ComboPooledDataSource dataSource=new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(JdbcUrl);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            return dataSource;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
