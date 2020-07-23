package com.mashibing.juc.c_020_01_Interview.ProductorCustomer;

/**
 * @author zl(952999)
 * @description: 消费者
 * @date 2020-07-23 10:48
 */
public class Consumer extends Thread {
    /**
     * 每次消费的产品数量
     */
    private int num;

    /**
     * 所在放置的仓库
     */
    private AbstractStorage abstractStorage1;

    /**
     * 构造函数，设置仓库
     */
    public Consumer(AbstractStorage abstractStorage1) {
        this.abstractStorage1 = abstractStorage1;
    }

    /**
     * 线程run函数
     */
    @Override
    public void run() {
        consume(num);
    }

    /**
     * 调用仓库Storage的生产函数
     */
    public void consume(int num) {
        abstractStorage1.consume(num);
    }

    public void setNum(int num) {
        this.num = num;
    }
}
