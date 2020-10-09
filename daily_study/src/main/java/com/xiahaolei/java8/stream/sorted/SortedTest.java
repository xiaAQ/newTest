package com.xiahaolei.java8.stream.sorted;

import java.util.Random;

public class SortedTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }
}
