package com.java.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-06-06 16:19
 */
public class Main {
    // 此处需要说明：Enhancer实际属于CGLIB包的，也就是`net.sf.cglib.proxy.Enhancer`
    // 但是Spring把这些类都拷贝到自己这来了，因此我用的Spring的Enhancer，包名为;`org.springframework.cglib.proxy.Enhancer`
    public static void main(String[] args) throws Exception {
        Enhancer enhancer = new Enhancer();
        // 注意此处的类型必须是实体类
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new CglibMethodInterceptor());

        HelloServiceImpl helloService = (HelloServiceImpl) enhancer.create();
        helloService.hello();
    }
}
