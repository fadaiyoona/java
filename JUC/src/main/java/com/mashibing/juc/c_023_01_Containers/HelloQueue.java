package com.mashibing.juc.c_023_01_Containers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HelloQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
        q.add(0);
        q.add(1);
        System.out.println(q);
        q.put(2);
        q.add(2);
        q.add(3);
        System.out.println(q);


    }
}
