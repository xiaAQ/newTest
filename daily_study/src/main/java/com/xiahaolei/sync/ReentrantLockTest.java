package com.xiahaolei.sync;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static ConcurrentHashMap chm = new ConcurrentHashMap();

    public static void main(String[] args) throws InterruptedException {
       chm.put("1","1");
       chm.get("1");
    }
}