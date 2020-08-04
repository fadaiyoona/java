package com.mashibing.juc.c_026_01_ThreadPool.abstract_executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-08-04 17:31
 */
public class ExecutorServiceDemo_invokeAll {
    public static void main(String[] args) throws Exception {
        ExecutorService e = Executors.newFixedThreadPool(3);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> {
            Thread.currentThread().sleep(3000);
            return "111";
        });
        callables.add(() -> {
            Thread.currentThread().sleep(3000);
            return "222";
        });
        callables.add(() -> {
            Thread.currentThread().sleep(3000);
            return "333";
        });
        try {
            // invokeAll方法就已实现了阻塞。AbstractExecutorService中实现了该逻辑，即等待所有任务的返回结果，进行聚合返回，如果超时则取消后面的任务。
//        List<Future<String>> futures = e.invokeAll(callables);
            List<Future<String>> futures = e.invokeAll(callables, 3, TimeUnit.SECONDS);
//        List<Future<String>> futures = e.invokeAll(callables, 2, TimeUnit.SECONDS);
            List<String> result = new ArrayList<>(futures.size());
            for (Future<String> future : futures) {
                if (future.isDone() && !future.isCancelled()) {
                    result.add(future.get());
                }
            }
            System.out.println(result);
            System.out.println("------------done--------------");
        } finally {
            e.shutdownNow();
        }
    }
}
