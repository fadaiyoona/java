package com.mashibing.juc.c_021_02_AQS.aqs2;

import java.util.concurrent.locks.Lock;

public class Main {
    public static /* volatile */ int m = 0;
    public static Lock lock = new MLock();

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];

        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                try {
                    lock.lock();
                    for (int j = 0; j < 100; j++) m++;
                } finally {
                    lock.unlock();
                }
            });
        }

        new Thread(() -> {
            while (true) {
                if (m == 5000) {
                    System.out.println("m == 5000");
                    System.out.println("new thread end...");
                    return;
                }
            }
        }).start();

        for(Thread t : threads) t.start();

        for (Thread t : threads) t.join();

        System.out.println(m);
    }
}