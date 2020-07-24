package com.mashibing.juc.c_021_02_AQS.aqs;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zl(952999)
 * @description: AQS源码实现原理：自旋（循环）、CAS（原子性）、LockSupport（阻塞、释放）
 * @date 2020-07-24 20:08
 */
public class AQSSourceCodeService {
    /** 状态 */
    private volatile int state = 0;

    private final static Unsafe UNSAFE = UnsafeInstance.reflectGetUnsafe();
    /** state 的偏移量 */
    private static long STATE_OFFSET;
    /** 当前线程 */
    private Thread lockHolder;
    /** 等待线程队列FIFO */
    private final ConcurrentLinkedDeque<Thread> threads = new ConcurrentLinkedDeque<>();

    static {
        try {
            STATE_OFFSET = UNSAFE.objectFieldOffset(AQSSourceCodeService.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CAS算法修改值
     * @param except 当前值
     * @param update 预期值
     * @return 是否成功
     */
    private boolean compareAndSwapState(int except, int update) {
        // 当前对象，当前对象所在的位置，需修改的值，修改后的值
        return UNSAFE.compareAndSwapInt(this, STATE_OFFSET, except, update);
    }

    public void AQS() {
        /* 此处加锁 */
        Thread current = Thread.currentThread();
        for (;;) {
            int state = getState();
            if (state == 0) {
                // 进行加锁
                if (compareAndSwapState(state, 1)) {
                    // 加锁成功
                    lockHolder = current;
                    break;
                }
            }
            // 加锁失败，如等待队列
            threads.add(current);
            LockSupport.park();
        }

        /* 加锁成功则执行逻辑程序 */

        /* 释放锁 */
        for (;;) {
            int state = getState();
            if (state != 0 && lockHolder == current) {
                compareAndSwapState(state, 0);
                break;
            }
            if (threads.size() > 0) {
                LockSupport.unpark(threads.poll());
            }
        }
    }

    private int getState() {
        return state;
    }
}
