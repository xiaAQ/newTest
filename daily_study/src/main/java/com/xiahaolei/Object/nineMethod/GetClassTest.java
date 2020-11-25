package com.xiahaolei.Object.nineMethod;

import com.xiahaolei.Object.People;

public class GetClassTest {
    public static void main(String[] args) {
        People p = new People(1, "2", "3");
        System.out.println(p.getClass());
        System.out.println(p.getClass().getName());
    }
}
