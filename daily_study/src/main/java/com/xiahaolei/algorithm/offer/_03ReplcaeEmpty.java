package com.xiahaolei.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/2/25 10:00
 * @Desc :替换字符串中的空格为JXQ
 */
public class _03ReplcaeEmpty {
    public static void main(String[] args) {
        String replaceEmpty = replaceEmpty("nihao xiahaolei jiayou xiaoahoeli");
        System.out.println(replaceEmpty);
    }

    //试用Stringbuilder 或者Stringbuffer 替换
    public static String replaceEmpty(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("JXQ");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
