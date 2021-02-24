package com.xiahaolei.daily_study.test;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        System.out.println(StringUtils.join(set.toArray(), ","));
    }
}
