package com.xiahaolei.utils.date;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class TimeUtils {
    public static void main(String[] args) {
        Date time = new Date();
        time = DateUtils.setHours(time, 10);
        time = DateUtils.setMinutes(time, 0);
        time = DateUtils.setSeconds(time, 0);
        time = DateUtils.setMilliseconds(time, 0);
        System.out.println(time);
        Date startTime = DateUtils.addDays(time, -1);
        System.out.println(startTime);

    }
}
