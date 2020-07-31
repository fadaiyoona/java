package com.mashibing.juc.c_022_RefTypeAndThreadLocal;


/**
 * @author zl(952999)
 * @description:
 * @date 2020-07-31 21:27
 */
public class ThreadLocal3 {
    private static A a = new A();

    private static final ThreadLocal<A> threadLocal = new ThreadLocal<A>() {
        @Override
        protected A initialValue() {
            return a;
        }
    };

//    private static final ThreadLocal<A> threadLocal = new ThreadLocal<A>();

    public static void main(String[] args) {
        threadLocal.set(a);
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get().getNumber());
                    threadLocal.get().setNumber(threadLocal.get().getNumber() + 5);
                    System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get().getNumber());
                }
            }, "Thread-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class A {
    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
