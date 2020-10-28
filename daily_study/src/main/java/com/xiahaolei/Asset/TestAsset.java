package com.xiahaolei.Asset;

import org.springframework.util.Assert;

public class TestAsset {
    /**
     * 断言和异常的区别：
     *  异常的使用场景：用于捕获外部的可能错误
     *  断言的使用场景：用于捕获内部的不可能错误
     * @param args
     */
    public static void main(String[] args) {
        String userId = null;
        Assert.notNull(userId, "用户Id不可以为空");
        System.out.println("keyiwei kong ");
    }
}
