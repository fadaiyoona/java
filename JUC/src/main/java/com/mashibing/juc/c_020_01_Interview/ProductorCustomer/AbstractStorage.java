package com.mashibing.juc.c_020_01_Interview.ProductorCustomer;

/**
 * @author zl(952999)
 * @description: 抽象仓库类
 * @date 2020-07-23 10:47
 */
public interface AbstractStorage {
    /**
     * 消费产品
     * @param num
     */
    void consume(int num);

    /**
     * 生产产品
     * @param num
     */
    void produce(int num);
}
