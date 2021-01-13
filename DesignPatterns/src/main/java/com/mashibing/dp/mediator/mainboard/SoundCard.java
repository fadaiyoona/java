package com.mashibing.dp.mediator.mainboard;

/**
 * @author zl(952999)
 * @description: 同事类——声卡
 * @date 2021-01-09 16:54
 */
public class SoundCard extends Colleague {
    /**
     * 构造函数
     */
    public SoundCard(Mediator mediator) {
        super(mediator);
    }
    /**
     * 按照声频数据发出声音
     */
    public void soundData(String data){
        System.out.println("画外音：" + data);
    }
}
