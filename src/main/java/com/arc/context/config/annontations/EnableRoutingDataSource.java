package com.arc.context.config.annontations;

import com.arc.context.config.datasource.RoutingDataSourceConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RoutingDataSourceConfiguration.class)
@Documented
public @interface EnableRoutingDataSource {

}
