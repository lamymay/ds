package com.arc.context.config.datasource;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * MybatisConfiguration
 *
 * @author lamymay@outlook.com
 */
@Configuration
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
// 在数据库自动装配后启动本类
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@MapperScan("com.arc.ds.mapper")
public class MybatisConfiguration {

    /**
     * 这里使用的是动态数据源
     * 项目中是有多个数据源的，3个主备库各一个+动态数据源共3个
     */
    @Resource(name = "arcDynamicRoutingDataSource")
    private DataSource dynamicRoutingDataSource;

    @Bean(name = "sqlSessionFactory")
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        // Session Factory
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        sqlSessionFactoryBean.setDataSource(dynamicRoutingDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


}
