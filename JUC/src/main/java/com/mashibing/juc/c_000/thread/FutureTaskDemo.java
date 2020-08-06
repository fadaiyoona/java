package com.mashibing.juc.c_000.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-08-06 10:04
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(testFutureTask());

        System.out.println("main done ...");
    }

    private static Object testFutureTask() throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.currentThread().sleep(10000);
                System.out.println("thread done ...");
                return "111";
            }
        });

        futureTask.run();
        System.out.println(futureTask.get());
        return futureTask.get();
    }
}
