package com.xiahaolei.Thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2020/12/21 9:47
 */
public class Worker implements Runnable{
    private CountDownLatch downLatch;
    private String name;

    public Worker(CountDownLatch downLatch, String name){
        this.downLatch = downLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.doWork();
        try{
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }catch(InterruptedException ie){
        }
        System.out.println(this.name + "活干完了！");
        this.downLatch.countDown();

    }

    private void doWork(){
        System.out.println(this.name + "正在干活!");
    }
}
