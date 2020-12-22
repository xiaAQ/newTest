package com.xiahaolei.Thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2020/12/21 9:48
 */
public class MainTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);

        Worker w1 = new Worker(latch,"张三");
        Worker w2 = new Worker(latch,"李四");
        Worker w3 = new Worker(latch,"王二");

        //调用await，等待其他的线程执行完毕
        Boss boss = new Boss(latch);
        executor.execute(boss);//无论放在哪里，因为调用了await的方法，就要等待await后，才可以执行execute的方法
        executor.execute(w3);
        executor.execute(w2);
        executor.execute(w1);

        executor.shutdown();
    }
}
