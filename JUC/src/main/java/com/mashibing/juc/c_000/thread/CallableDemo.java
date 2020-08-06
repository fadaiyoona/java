package com.mashibing.juc.c_000.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-08-06 10:04
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(testCallable());

        System.out.println("main done ...");
    }

    private static Object testCallable() throws Exception {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.currentThread().sleep(10000);
                System.out.println("thread done ...");
                return "111";
            }
        };
        return callable.call();
    }
}
