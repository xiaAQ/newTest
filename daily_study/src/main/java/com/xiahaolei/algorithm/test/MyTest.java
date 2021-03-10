package com.xiahaolei.algorithm.test;

import org.apache.commons.lang3.StringUtils;

import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/3/8 10:06
 */
public class MyTest {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("1");


        String obligorName = StringUtils.join(strings.stream().map(e -> e).distinct().toArray(), ",");
        System.out.println(obligorName);
    }
}
