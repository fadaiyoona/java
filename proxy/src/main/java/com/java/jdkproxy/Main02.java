package com.java.jdkproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-06-06 16:10
 */
public class Main02 {
    public static void main(String[] args) throws Exception {
        // 三个步骤：
        // 1、生成代理接口的Class（） class com.sun.proxy.$Proxy0
        // 2、拿到构造器：public com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler)
        // 3、new一个InvocationHandler实例~~~
        Class<?> proxyClass = Proxy.getProxyClass(Main02.class.getClassLoader(), HelloWorldService.class);
        Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
        InvocationHandler ih = new JdkInvocationHandler(new HelloWorldServiceImpl());

        // 通过构造函数 new出一个实例
        HelloWorldService helloWorld = (HelloWorldService) cons.newInstance(ih);

        helloWorld.sayHello();

    }
}
