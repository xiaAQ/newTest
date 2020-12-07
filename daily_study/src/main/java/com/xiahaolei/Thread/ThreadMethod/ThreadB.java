package com.xiahaolei.Thread.ThreadMethod;

public class ThreadB extends Thread{
        public ThreadB(String name) {
            super(name);
        }
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run ");
            // 死循环，不断运行。
            while(true){

            }  //  这个线程与主线程无关，无 synchronized
    }
}
