package com.xiahaolei.java8.multimap;

import com.google.common.collect.HashMultimap;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2020/12/22 9:40
 */
public class MultiMap {
    public static void main(String[] args) {
        /**
         * multimap和MultiSet的继承结果很相似，只不过在上层的接口是Multimap不是Multiset。
         *
         * Multimap的特点其实就是可以包含有几个重复Key的value，你可以put进入多个不同value但是相同的key，但是又不是让后面覆盖前面的内容。
         *
         * 它的业务场景：当你需要构造像Map<K, List<V>>或者Map<K, Set<V>>这样比较复杂的集合类型的数据结构，来做相应的业务逻辑处理。那Multimap在合适不过。
         */
        HashMultimap<Integer, Integer> map = HashMultimap.create();
        map.put(1, 2);
        map.put(1, 3);
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 2);
        map.put(4, 3);
        map.put(4, 2);
        map.put(4, 3);
        System.out.println(map.toString());

    }
}
