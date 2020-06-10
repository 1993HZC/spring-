package com.markov.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.markov")
//引用JDBCConfig这个类为配置类，也要加载JDBCConfig里面的配置
//将配置类JDBCconfig这个类视为Config配置类的子类
@Import(JDBCconfig.class)
//指定配置类文件 也可以是PropertySources负数，可以添加多个文件名字
@PropertySources({@PropertySource("classpath:jdbcConfig.properties"),
        @PropertySource("classpath:fastjson.properties")})
public class Config {

}
