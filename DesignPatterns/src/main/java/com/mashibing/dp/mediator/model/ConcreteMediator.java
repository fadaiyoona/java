package com.mashibing.dp.mediator.model;

/**
 * @author zl(952999)
 * @description: 具体调停者
 * @date 2021-01-09 16:39
 */
public class ConcreteMediator implements Mediator {
    /** 持有并维护同事A */
    private ConcreteColleagueA colleagueA;
    /** 持有并维护同事B */
    private ConcreteColleagueB colleagueB;

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    @Override
    public void changed(Colleague c) {
        /**
         * 某一个同事类发生了变化，通常需要与其他同事交互
         * 具体协调相应的同事对象来实现协作行为
         */
    }
}
