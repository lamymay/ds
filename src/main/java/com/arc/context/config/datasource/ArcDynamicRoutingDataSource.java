package com.arc.context.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * Extends {@link AbstractRoutingDataSource}<p>
 * Determine the data source from current lookup key.
 * 基于 AbstractRoutingDataSource 和 AOP 的多数据源的配置
 * 我们自己定义一个DataSource类，来继承 AbstractRoutingDataSource：
 *
 * @author lamymay@outlook.com
 */
public class ArcDynamicRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 这里通过determineCurrentLookupKey（）
     * 返回的不同key到sqlSessionFactory中获取对应数据源然后使用ThreadLocal来存放线程的变量，将不同的数据源标识记录在ThreadLocal中
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSourceType();
    }


}
