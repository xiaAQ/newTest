package com.xiahaolei.daily_study.controller;

import cn.hutool.core.net.NetUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/1/14 17:42
 */
public class Test {
    private final static int a;
    private final static int b;

    static {
        a = 100;
        b = 1111;

    }

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
//        getIpAddr()；
        InetAddress localhost = NetUtil.getLocalhost();
        System.out.println(localhost);
    }

    /**
     * 获取登录用户的IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
