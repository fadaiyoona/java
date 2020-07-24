package com.mashibing.juc.c_000.thread;

/**
 * @author zl(952999)
 * @description: 执行多遍，结果可发现，都是首先输出：1线程: 第1位访客来啦！所以可以看出 yield 不会释放对象锁，别的线程进入不了。
 * @date 2020-07-24 19:58
 */
public class YieldDemo2 implements Runnable {
    /** 系统访问次数 */
    private /* volatile */ int count = 0;

    @Override
    public synchronized void run() {// 通过synchronized实现同步
        count++;
        try {
            if (count == 1) {
                /// <注>. sleep 和 yield 都不会释放 <锁资源>。
                // Thread.sleep(5000);
                Thread.yield();

                // this.wait();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println(Thread.currentThread().getName() + "线程: " + "第" + count + "位访客来啦！");
    }

    public static void main(String[] args) {
        YieldDemo2 rd = new YieldDemo2();
        for (int i = 1; i <= 50; i++) {
            Thread thread = new Thread(rd, String.valueOf(i));
            thread.start(); // 一定要注意不是通过.run()启动线程
        }
    }
}
