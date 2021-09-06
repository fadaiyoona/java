package com.mashibing.juc.c_p_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-10-19 20:09
 */
@SuppressWarnings("all")
public class SourceFutureTask {
    public static void main(String[] args) throws Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                System.out.println("thread done ...");
                return "hello world";
            }
        });
        futureTask.run();
//        executorService.submit(futureTask);
        System.out.println(futureTask.get());
//        executorService.shutdown();
    }
}
