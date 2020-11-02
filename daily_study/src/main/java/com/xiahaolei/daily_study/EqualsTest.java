package com.xiahaolei.daily_study;

public class EqualsTest {
    /**
     * 对于==来说，integer在-128到127的范围内比较的是值，但是当超过了这个范围的话，就会相当于新的new的对象
     * 两个不同的数据类型相当于两个新的对象，所以比较的值为false
     * * @param args
     */
    public static void main(String[] args) {
        Integer integer = 128;
        Integer int1 = 128;
        boolean b = int1 == integer;
        System.out.println(b);
    }
}
