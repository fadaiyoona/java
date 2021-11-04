package com.java.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-06-06 16:09
 *
 * 参考JdkDynamicAopProxy标准实现
 *
 * JDK代理的方式，在整个创建过程中，对于InvocationHandler的创建时最为核心的，在自定义的InvocationHandler中需要重写3个函数
 * 1、构造函数，将代理的对象传入（此类实现时，将一些数据都放在了AdvisedSupport advised中）
 * 2、invoke方法，此方法中实现了AOP增强的所有逻辑。
 * 3、getProxy方法，此方法千篇一律，但是必不可少。
 *
 * Spring在创建Aop代理的时候，也是按照上面的架构来实现的，可见在此类中对标实现了上面的方法。
 */
public class JdkInvocationProxy implements InvocationHandler {
    private Object target;

    public JdkInvocationProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method :" + method.getName() + " is invoked!");
        return method.invoke(target, args);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
