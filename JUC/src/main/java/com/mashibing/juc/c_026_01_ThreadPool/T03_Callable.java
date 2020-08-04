/**
 * 认识Callable，对Runnable进行了扩展
 * 对Callable的调用，可以有返回值
 */
package com.mashibing.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable() {
            @Override
            public String call() throws Exception {
                return "Hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c); //异步
        Future future1 = service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10000);
                    System.out.println("------sleep over-------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(future.get());//阻塞

        service.shutdown();
    }

}
