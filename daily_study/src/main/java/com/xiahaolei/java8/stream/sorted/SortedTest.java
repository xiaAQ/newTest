package com.xiahaolei.java8.stream.sorted;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

public class SortedTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person object = new Person("尚佳鹏", 12, "男", DateUtils.addDays( new Date(),1));
        Person object2 = new Person("李鹏", 13, "女",DateUtils.addDays( new Date(),3));
        Person object1 = new Person("标哥", 22, "男",DateUtils.addDays( new Date(),4));
        Person object3 = new Person("姚孟", null, "男",DateUtils.addDays( new Date(),2));
        list.add(object);
        list.add(object1);
        list.add(object2);
        list.add(object3);
        System.err.println("1.不做任何处理的输出");
        for (Person streamTest : list) {
            System.out.println(streamTest);
        }
        System.out.println("=====================================");
        System.out.println("2.倒序后的输出");
        //利用Stream流对集合数据进行倒序排序
        Collections.sort(list, (a, b) -> b.getBirthday().compareTo(a.getBirthday() == null ? null : a.getBirthday()));
        for (Person streamTest : list) {
            System.err.println(streamTest);
        }

    }
}
