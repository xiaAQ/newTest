package com.xiahaolei.md5;


import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Serect {
    /**
     *1.首先明确一点：就是md5的加密是个不可逆的过程，abc可以加密成（32或者16位的字符串，但是没有办法把加密后的字符串解密成abc）
     *2。所以这就导致如果使用
     */

    public static String testMd5(String str){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {

            e.printStackTrace();

            return str;

        }
    }

    public static void main(String[] args) {
        String xia = testMd5("xia");
        System.out.println(xia);
    }
}
