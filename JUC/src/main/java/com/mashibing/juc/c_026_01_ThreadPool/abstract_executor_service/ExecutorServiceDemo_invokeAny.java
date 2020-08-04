package com.mashibing.juc.c_026_01_ThreadPool.abstract_executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-08-04 17:31
 */
public class ExecutorServiceDemo_invokeAny {
    public static void main(String[] args) throws Exception {
        ExecutorService e = Executors.newFixedThreadPool(3);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> {
            Thread.currentThread().sleep(3000);
            return "111";
        });
        callables.add(() -> {
            Thread.currentThread().sleep(4000);
            return "222";
        });
        callables.add(() -> {
            Thread.currentThread().sleep(5000);
            return "333";
        });
        try {
//        String futures = e.invokeAny(callables);
//        String futures = e.invokeAny(callables, 3, TimeUnit.SECONDS);
            String futures = e.invokeAny(callables, 2, TimeUnit.SECONDS);
            System.out.println(futures);
        } finally {
            System.out.println("------------done--------------");
            e.shutdownNow();
        }
    }
}
