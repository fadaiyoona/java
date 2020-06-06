package com.java.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author zl(952999)
 * @description:
 * VM参数：-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
 * @date 2020-06-06 16:09
 */
public class Main01 {

    public static void main(String[] args) throws Exception {
        // 传入三大参数，就能够创建出一个代理对象
        HelloWorldService helloWorld = (HelloWorldService) Proxy.newProxyInstance(
                Main01.class.getClassLoader(),
                new Class<?>[]{HelloWorldService.class},
                //此处目标实现为HelloWorldImpl
                new JdkInvocationHandler(new HelloWorldServiceImpl()));
        helloWorld.sayHello();
    }
}
