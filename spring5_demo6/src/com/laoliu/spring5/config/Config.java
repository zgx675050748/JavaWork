package com.laoliu.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration  //声明配置类
@ComponentScan(basePackages = "com.laoliu.spring5")  //开启注解扫描
@EnableTransactionManagement  //开启事务
@PropertySource("classpath:jdbc.properties") //注解方式引入外部属性配置文件
public class Config {
    //创建数据库连接池

    @Value("${prop.driverClassName}")
    private String driverClassName;
    @Value("${prop.url}")
    private String url;
    @Value("${prop.username}")
    private String username;
    @Value("${prop.password}")
    private String password;

    @Bean   //创建druid连接池对象，使用外部配置文件导入
    public DruidDataSource druidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }

    @Bean  //创建JdbcTemplate对象，使用druid连接池对象自动匹配数据源
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean  //创建事务管器对象，使用druid连接池对象自动匹配数据源
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
