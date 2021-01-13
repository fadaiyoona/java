package com.mashibing.dp.mediator.model;

/**
 * @author zl(952999)
 * @description: 具体同事类A
 * @date 2021-01-09 16:42
 */
public class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    /**
     * 示意方法，执行某些操作
     */
    public void operation(){
        //在需要跟其他同事通信的时候，通知调停者对象
        getMediator().changed(this);
    }
}
