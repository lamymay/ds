package com.arc.ds;

import com.arc.context.config.annontations.EnableMybatis;
import com.arc.context.config.annontations.EnableRoutingDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
                JdbcTemplateAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class
        }
)
//https://www.cnblogs.com/adversary/p/10346278.html  如何用注解的形式改进引入
//下面两个是自定义注解 EnableMybatis EnableRoutingDataSource，实现的功能等效 @ImportAutoConfiguration({MybatisConfiguration.class, RoutingDataSourceConfiguration.class})
@EnableMybatis
@EnableRoutingDataSource
@RestController
public class DsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsApplication.class, args);
    }



}
