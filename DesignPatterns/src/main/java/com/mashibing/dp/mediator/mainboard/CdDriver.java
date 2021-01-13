package com.mashibing.dp.mediator.mainboard;

/**
 * @author zl(952999)
 * @description: 同事类——光驱
 * @date 2021-01-09 16:51
 */
public class CdDriver extends Colleague {
    /** 光驱读取出来的数据 */
    private String data = "";

    /**
     * 构造函数
     */
    public CdDriver(Mediator mediator) {
        super(mediator);
    }

    /**
     * 获取光盘读取出来的数据
     */
    public String getData() {
        return data;
    }

    /**
     * 读取光盘
     */
    public void readCD() {
        //逗号前是视频显示的数据，逗号后是声音
        this.data = "One Piece,海贼王我当定了";
        //通知主板，自己的状态发生了改变
        getMediator().changed(this);
    }
}
