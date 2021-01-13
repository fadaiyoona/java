package com.mashibing.dp.mediator.mainboard;

/**
 * @author zl(952999)
 * @description: 抽象调停者类
 * @date 2021-01-09 16:37
 */
public interface Mediator {

    /**
     * 同事对象在自身改变的时候来通知调停者方法，让调停者去负责相应的与其他同事对象的交互
     * @param c 同事对象
     */
    void changed(Colleague c);
}
