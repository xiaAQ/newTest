package com.xiahaolei.java8.thread;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2020/12/29 9:46
 */
public class ClassTest {
    /**
     * 测试定时任务1 每天22:00:00执行
     */
    @Scheduled(cron = "0 0 22 * * ?")
    public void test() {

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=======================测试定时任务执行1=======================");
        }
    }

    /**
     * 测试定时任务2 每天22:10:00执行
     */
    @Scheduled(cron = "0 10 22 * * ?")
    public void test2() {

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=======================测试定时任务执行2=======================");
        }
    }
}
