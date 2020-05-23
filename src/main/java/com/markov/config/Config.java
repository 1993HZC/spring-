package com.markov.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.markov")
@Import(JDBCconfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class Config {

}
