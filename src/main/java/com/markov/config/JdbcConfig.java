package com.markov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcConfig {
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.Url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;

    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DriverManagerDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean("dataSource")
    public DriverManagerDataSource createDataSource(){
        DriverManagerDataSource driverManagerDataSource =new DriverManagerDataSource();
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setUsername(user);
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setUrl(url);
        return driverManagerDataSource;
    }
}
