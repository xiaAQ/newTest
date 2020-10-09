package com.xiahaolei.java8.stream.foreach;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        List<String> newList = new ArrayList<String>();
        list.stream().forEach(e->newList.add(e));
        System.out.println(newList);
    }
}
