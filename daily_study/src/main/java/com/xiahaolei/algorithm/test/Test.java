package com.xiahaolei.algorithm.test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/3/14 11:20
 */
public class Test {
    public static void main(String[] args) {
        List<Person> dataList = getDataList();
//按照名称排序
        Collections.sort(dataList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //排序规则：按照汉字拼音首字母排序
                Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
                return com.compare(o1.getName(), o1.getName());
                //t2 t1 交换可以改变排序顺序
            }
        });
        System.out.println(dataList);
    }

    private static List<Person> getDataList() {
        List<Person> testPersonList = new ArrayList<>();
        Person p = Person.builder().name("王霸之气").age(11).build();
        Person p1 = Person.builder().name("算测").age(11).build();
        Person p2 = Person.builder().name("字段").age(11).build();
        testPersonList.add(p);
        testPersonList.add(p1);
        testPersonList.add(p2);
        return testPersonList;
    }
}
