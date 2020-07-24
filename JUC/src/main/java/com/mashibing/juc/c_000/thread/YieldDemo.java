package com.mashibing.juc.c_000.thread;

/**
 * @author zl(952999)
 * @description: Thread.yield() 方法，使当前线程由执行状态，变成为就绪状态，让出cpu时间，在下一个线程执行时候，此线程有可能被执行，也有可能没有被执行。
 * @date 2020-07-24 19:53
 */
public class YieldDemo extends Thread {
    public YieldDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldDemo yt1 = new YieldDemo("张三");
        YieldDemo yt2 = new YieldDemo("李四");
        yt1.start();
        yt2.start();
    }
}
