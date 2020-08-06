package com.mashibing.juc.c_000.thread;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-08-06 10:04
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(testThread());

        System.out.println("main done ...");
    }

    private static Object testThread() throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10000);
                    System.out.println("thread done ...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        return "111";
    }
}
