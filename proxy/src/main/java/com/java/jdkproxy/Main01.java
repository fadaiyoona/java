package com.java.jdkproxy;

/**
 * @author zl(952999)
 * @description:
 * VM参数：-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
 * @date 2020-06-06 16:09
 */
public class Main01 {

    public static void main(String[] args) throws Exception {
        // 实例化一个需要代理的对象
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        // 实例化InvocationHandler
        JdkInvocationProxy jdkInvocationProxy = new JdkInvocationProxy(helloWorldService);
        // 根据目标对象生成代理对象
        HelloWorldService proxy = (HelloWorldService) jdkInvocationProxy.getProxy();
        // 调用代理对象方法
        proxy.sayHello();
    }
}
