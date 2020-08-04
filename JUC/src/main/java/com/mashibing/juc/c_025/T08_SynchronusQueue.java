package com.mashibing.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *SynchronusQueue内部没有单独维护一个队列，只能使用put方法，TransferQueue同理，只能使用transfer、put方法。
 */
public class T08_SynchronusQueue { //容量为0
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();

		new Thread(()->{
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		strs.put("aaa"); //阻塞等待消费者消费
		//strs.put("bbb");
//		strs.add("aaa");// Queue full
		System.out.println(strs.size());

		/************************* demo2 *************************/
		new Thread(()->{
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(()->{
			try {
				strs.put("aaa");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
