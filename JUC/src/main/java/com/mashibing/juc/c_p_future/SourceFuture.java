package com.mashibing.juc.c_p_future;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-10-19 20:09
 */
public class SourceFuture {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            2, 4,
            60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(4),
            new ThreadFactoryBuilder().setNameFormat("SourceFuture-%d").build(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws Exception {
        Future<String> future = THREAD_POOL_EXECUTOR.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                System.out.println("thread done ...");
                return "hello world";
            }
        });
        // 阻塞
        String result = future.get();
        System.out.println(result);
        THREAD_POOL_EXECUTOR.shutdown();
    }
}
