package com.mashibing.dp.mediator.mainboard;

/**
 * @author zl(952999)
 * @description: 抽象同事类
 * @date 2021-01-09 16:41
 */
public abstract class Colleague {
    /** 持有一个调停者对象 */
    private Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }

    /**
     * 获取当前同事类对应的调停者对象
     */
    public Mediator getMediator() {
        return mediator;
    }
}
