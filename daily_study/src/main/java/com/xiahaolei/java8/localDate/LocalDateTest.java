package com.xiahaolei.java8.localDate;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTest {
    @Test //1.测试Date
    public void testDate() {
        Date date = new Date();
        System.out.println(date);
        //simpleDateFormat是线程不安全的，因为底层使用的是calendar，如果当被statis修饰的时候机会出现变成共享变量，导致同时访问然后进行修改，导致数据的不正确性。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
        /**
         * 解决办法
         * 1.设置局部变量SimpleDateFormat
         * 2.加锁
         * 3.使用localThread 保证线程间的安全性
         * 4.使用jdk8的新特性。LocalDate
         */
    }


    @Test
    public void testLocalDate() {
        //当前的年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //当前的时分秒
        LocalTime now = LocalTime.now();
        System.out.println(now);
        //构造指定的年月日
        LocalDate buildDate = LocalDate.of(2019, 9, 10);
        System.out.println(buildDate);
        System.out.println(localDate+" "+now);
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);


    }
    @Test
    public void test3(){
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);
        //DateTimeFormatter默认提供了多种格式化方式，如果默认提供的不能满足要求，可以通过DateTimeFormatter的ofPattern方法创建自定义格式化方式
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    @Test
    public void test4(){
        LocalDate localDate1 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDate1);
        System.out.println(localDate2);

    }


}

