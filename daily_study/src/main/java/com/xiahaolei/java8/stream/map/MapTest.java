package com.xiahaolei.java8.stream.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Map是Stream的流的中间操作，不会对数据进行保存，如果没有进行终止操作的话，会导致数据出现问题
 */
public class MapTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        List<String> collect = list.stream().map(e -> {
            if (e.equals("1")) {
                e = "1000";
            }
            return e;
        }).collect(Collectors.toList());
        System.out.println(collect);
        List<String> stringList = new ArrayList<>();
        collect.stream().map(e->stringList.add(e)).collect(Collectors.toList());
        System.out.println(stringList);
    }
}