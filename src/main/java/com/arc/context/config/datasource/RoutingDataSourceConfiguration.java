package com.arc.context.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class RoutingDataSourceConfiguration implements TransactionManagementConfigurer {
    /*
     * springboot使用spring-boot-autoconfigure
     * DataSourceAutoConfiguration会初始化DataSourceInitializer,
     * 初始化时调用init方法会去获取DataSource 初始化方法中会获取数据源 需要初始化一些ddl操作也是就runSchemaScripts()方法
     * 检查初始化时是否需要执行sql script,当你有两个数据源的时候,程序不知道取哪一个,则会报错
     * 所以@Primay告诉springboot,优先使用哪个数据源
     */
    @Primary
    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "arc.datasource.db0")
    public DataSource writeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "arc.datasource.db1")
    public DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "arcDynamicRoutingDataSource")
    public DataSource routingDataSource() {
        ArcDynamicRoutingDataSource arcDynamicRoutingDataSource = new ArcDynamicRoutingDataSource();
        Map<Object, Object> allDataSources = new HashMap<>();
        allDataSources.put(DynamicDataSourceType.WRITE, writeDataSource());
        allDataSources.put(DynamicDataSourceType.READ, readDataSource());
        arcDynamicRoutingDataSource.setTargetDataSources(allDataSources);
        arcDynamicRoutingDataSource.setDefaultTargetDataSource(writeDataSource());
        return arcDynamicRoutingDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(routingDataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

    @Bean
    public RoutingDataSourceServiceAop routingDatasourceServiceAop() {
        return new RoutingDataSourceServiceAop();
    }

}
