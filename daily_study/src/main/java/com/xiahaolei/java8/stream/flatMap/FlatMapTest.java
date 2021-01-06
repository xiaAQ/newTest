package com.xiahaolei.java8.stream.flatMap;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/1/6 15:54
 * @Descrip: map 其实就是一层的拿到，  而flatmap的话，其实就是压平，把所有的数据压缩到一个集合中
 */
public class FlatMapTest {
    @Test
    public  void test1() {
        List<String> words = Lists.newArrayList("java", "python", "php");
        words.stream()
                .map((word) -> word.split(""))
                .distinct()
                .map(Arrays::toString)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    @Test
    public void test2(){
        List<String> words = Lists.newArrayList("java", "python", "php");
        words.stream()
                .map((word) -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}