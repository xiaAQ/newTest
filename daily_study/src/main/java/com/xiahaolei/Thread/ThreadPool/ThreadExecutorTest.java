package com.xiahaolei.Thread.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,3,300, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一个线程");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二个线程");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第三个线程");
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第四个线程");
            }
        });
        threadPoolExecutor.submit(thread1);
//        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
        threadPoolExecutor.submit(thread2);
        threadPoolExecutor.submit(thread3);
        threadPoolExecutor.submit(thread4);
        Thread.sleep(2000);
        System.out.println(threadPoolExecutor);
        //调用shutDown的时候就是使线程停止
        threadPoolExecutor.shutdown();

    }
}
