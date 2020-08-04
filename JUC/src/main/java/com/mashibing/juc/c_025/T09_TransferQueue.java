package com.mashibing.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class T09_TransferQueue {
	public static void main(String[] args) throws Exception {
		method1();
		method2();
		method3();
	}

	private static void method1() throws Exception {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		System.out.println(strs.tryTransfer("aaa", 1, TimeUnit.SECONDS));
	}

	private static void method2() throws Exception {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

//		strs.transfer("aaa"); // 阻塞等待消费交换

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		strs.transfer("aaa");
//		System.out.println(strs.tryTransfer("aaa", 1, TimeUnit.SECONDS));

//		strs.put("aaa");

//		strs.tryTransfer("aaa");
	}

	private static void method3() throws Exception {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		strs.transfer("aaa");
		if (strs.hasWaitingConsumer()) {
			System.out.println("消费者个数 : " + strs.getWaitingConsumerCount());
			strs.transfer("aaa");
		}
	}
}
