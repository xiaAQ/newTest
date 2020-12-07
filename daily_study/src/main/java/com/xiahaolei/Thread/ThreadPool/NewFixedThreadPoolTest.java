package com.xiahaolei.Thread.ThreadPool;

import ch.qos.logback.core.net.QueueFactory;
import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.*;

public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        }).shutdown();


        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
    }
}
