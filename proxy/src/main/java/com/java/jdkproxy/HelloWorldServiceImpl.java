package com.java.jdkproxy;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-06-06 16:08
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void sayHello() {
        System.out.print("hello world");
    }
}
