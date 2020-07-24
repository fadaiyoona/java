package com.mashibing.juc.c_000.thread;

/**
 * @author zl(952999)
 * @description: join实现线程顺序执行，实现阻塞
 * @date 2020-07-24 11:53
 */
public class JoinDemo extends Thread {
    private int i;
    /**
     * 上一个线程
     */
    private Thread previousThread;

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            // 调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
            System.out.println("----------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("num:" + i);
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinDemo joinDemo = new JoinDemo(previousThread, i);
            joinDemo.start();
            previousThread = joinDemo;
        }
    }
}
