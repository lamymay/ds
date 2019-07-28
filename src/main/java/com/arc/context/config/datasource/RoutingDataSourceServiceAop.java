package com.arc.context.config.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * 说明： RoutingDataSourceServiceAop 该aop需要指定足够高的优先级(@Order(1))，以确保在服务获取数据源前将正确的数据源指定给他（绑定在ThreadLocal）
 *
 * @author lamymay@outlook.com
 */
@Aspect
@Order(1)
public class RoutingDataSourceServiceAop {

    @Pointcut("execution(* com.arc.ds.service..*.*(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
    public void aspect() {

    }

    @Around("aspect()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature msig = (MethodSignature) pjp.getSignature();
        Method method = pjp.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());
        Transactional transactional = method.getDeclaredAnnotation(Transactional.class);
        DynamicDataSourceHolder.setDataSourceType(transactional == null || !transactional.readOnly() ? DynamicDataSourceType.WRITE : DynamicDataSourceType.READ);
        return pjp.proceed();
    }

}
