package com.markov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

public class TransactionConfig {
    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransactionManager(DriverManagerDataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
