package com.xiahaolei.Object;

import java.util.Objects;

public class EqualsTest implements Cloneable {
    public static void main(String[] args) {
        //可以用来比较空值和别的值进行比较
        boolean equals = Objects.equals(null, 11);
        System.out.println(equals);
        boolean aNull = Objects.isNull(null);
        System.out.println(aNull);
        boolean b = Objects.nonNull(null);
    }
}
