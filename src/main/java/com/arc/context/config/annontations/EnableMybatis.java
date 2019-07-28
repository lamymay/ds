package com.arc.context.config.annontations;

import com.arc.context.config.datasource.MybatisConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MybatisConfiguration.class)
@Documented
public @interface EnableMybatis {

}
