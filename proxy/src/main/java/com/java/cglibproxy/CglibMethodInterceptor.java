package com.java.cglibproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-06-06 16:13
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 注意这里调用的是methodProxy.invokeSuper
        Object intercept = methodProxy.invokeSuper(o, objects);
        System.out.println("中介：该房源已发布！");
        return intercept;
    }
}
