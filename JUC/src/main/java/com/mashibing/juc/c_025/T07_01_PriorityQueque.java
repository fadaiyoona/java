package com.mashibing.juc.c_025;

import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class T07_01_PriorityQueque {
    public static void main(String[] args) {
//        PriorityQueue<String> q = new PriorityQueue<>();
        BlockingQueue<String> q = new PriorityBlockingQueue<>();
//        PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }
}
