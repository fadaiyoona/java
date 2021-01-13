package com.mashibing.dp.mediator.mainboard;

/**
 * @author zl(952999)
 * @description: 同事类——显卡
 * @date 2021-01-09 16:54
 */
public class VideoCard extends Colleague {
    /**
     * 构造函数
     */
    public VideoCard(Mediator mediator) {
        super(mediator);
    }
    /**
     * 显示视频数据
     */
    public void showData(String data){
        System.out.println("您正在观看的是：" + data);
    }
}
