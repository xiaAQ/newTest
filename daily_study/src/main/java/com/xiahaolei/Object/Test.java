package com.xiahaolei.Object;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        Integer integer = map.get("4");
        System.out.println(integer);
    }
}
