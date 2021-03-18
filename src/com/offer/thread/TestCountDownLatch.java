/*
 *
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
*/
package com.offer.thread;

import java.util.concurrent.CountDownLatch;

/*
 * 闭锁 CountDownLatch 的使用实例
 * @author jiaxiao
 * @version $$Id: TestCountDownLatch.java, v 0.1 17/4/9 上午9:19 jiaxiao Exp $$
*/
public class TestCountDownLatch {

    public void test(int nThreads, final Runnable task) throws InterruptedException {

        //启动门
        final CountDownLatch startGate = new CountDownLatch(1);
        //结束门
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for(int i = 0; i < nThreads; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //所有线程先等待启动，startGate达到0的状态
                        startGate.await();
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //逐步释放
                        endGate.countDown();
                    }

                }
            }).start();
        }

        long startTime = System.nanoTime();
        //主线程启动所有线程
        startGate.countDown();

        //主线程等待所有线程执行结束
        endGate.await();

        long endTime = System.nanoTime();

        System.out.println("test method cost: " + (endTime - startTime) + "ms");
    }
}
