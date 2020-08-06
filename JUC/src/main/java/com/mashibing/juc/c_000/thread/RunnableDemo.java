package com.mashibing.juc.c_000.thread;

/**
 * @author zl(952999)
 * @description:
 * @date 2020-08-06 10:04
 */
public class RunnableDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(testRunnable());

        System.out.println("main done ...");
    }

    private static Object testRunnable() throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10000);
                    System.out.println("thread done ...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        runnable.run();
        return "111";
    }
}
