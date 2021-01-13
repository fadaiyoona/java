package com.mashibing.dp.mediator.mainboard;

/**
 * @author zl(952999)
 * @description: 客户端
 * @date 2021-01-09 16:56
 */
public class Client {

    public static void main(String[] args) {
        //创建调停者——主板
        MainBoard mediator = new MainBoard();
        //创建同事类
        CdDriver cd = new CdDriver(mediator);
        Cpu cpu = new Cpu(mediator);
        VideoCard vc = new VideoCard(mediator);
        SoundCard sc = new SoundCard(mediator);
        //让调停者知道所有同事
        mediator.setCdDriver(cd);
        mediator.setCpu(cpu);
        mediator.setVideoCard(vc);
        mediator.setSoundCard(sc);
        //开始看电影，把光盘放入光驱，光驱开始读盘
        cd.readCD();
    }
}
