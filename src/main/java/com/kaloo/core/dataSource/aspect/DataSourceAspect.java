package com.kaloo.core.dataSource.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.transaction.annotation.Transactional;

import com.kaloo.core.dataSource.DynamicDataSourceHolder;
import com.kaloo.core.dataSource.annotation.DataSource;

public class DataSourceAspect {
	
	public void before(JoinPoint point) {
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        //Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        System.err.println("###################****************################");
        try {
            //Method m = classz[0].getMethod(method, parameterTypes);
        	Method m = target.getClass().getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(Transactional.class)) {
                DataSource data = m
                        .getAnnotation(DataSource.class);
                DynamicDataSourceHolder.set(data.value());
                System.err.println("###################!!!!!!!!"+data.value()+"!!!!!!!################");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
