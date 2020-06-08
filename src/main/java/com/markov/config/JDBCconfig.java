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

    //    这些value的值都是从jdbcConfig.properties里面来的
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
//    这个类会去bean容器中找到id 为dataSource的类作为参数传入进去,找不到就会报错
    public QueryRunner createRunner(ComboPooledDataSource dataSource){
        return new QueryRunner(dataSource);
    }
    //    这个注解是将这个方法的返回值 装载到bean容器之中 然后 将这个类的id是设置为 dataSource
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
