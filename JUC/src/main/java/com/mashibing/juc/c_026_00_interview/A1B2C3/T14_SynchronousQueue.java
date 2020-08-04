package com.mashibing.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.SynchronousQueue;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-08-04 09:53
 */
public class T14_SynchronousQueue {
    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        SynchronousQueue<Character> queue2 = new SynchronousQueue<Character>();
        new Thread(()->{
            try {
                for (char c : aI) {
                    System.out.print(queue2.take());
                    queue2.put(c);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            try {
                for (char c : aC) {
                    queue2.put(c);
                    System.out.print(queue2.take());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
