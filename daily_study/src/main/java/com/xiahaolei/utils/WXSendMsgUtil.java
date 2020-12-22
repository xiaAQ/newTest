package com.xiahaolei.utils;
/**
 * Copyright (C), 2018-2020
 * FileName: com.xiahaolei.utils.WXSendMsgUtil
 * Author:   Lee
 * Date:     2020/12/22 9:41
 * Description: 微信情话发送工具类
 * Problem: 需要本地登录微信才能通过快捷键打开并识别发送信息
 * History:
 */
import cn.hutool.http.HttpUtil;
import org.springframework.scheduling.annotation.Scheduled;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lee
 * @create 2020/12/22
 * @since 1.0.0
 */
public class WXSendMsgUtil {

    //获取执行时间
    public static Date getDate(Integer hour,Integer minute,Integer second){
        //设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天

        calendar.set(year, month, day, hour, minute, second);
        Date date = calendar.getTime();
        //如果启动时间超过执行时间，则明天执行
        if (date.before(new Date())) {
            date = addDay(date, 1);
        }
        return date;
    }

    // 增加或减少天数
    public static Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();
    }

    private static void searchPerson(String friendNickName)  {
        // 创建Robot对象
        Robot robot = getRobot();
        //打开微信 Ctrl+Alt+W
        assert robot != null;
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_Z);
        //释放Ctrl按键，像Ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ALT);

        // 该延迟不能少，否则无法搜索
        robot.delay(1000);

        // Ctrl + F 搜索指定好友
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // 将好友昵称发送到剪切板
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(friendNickName);
        clip.setContents(tText, null);
        // 以下两行按下了ctrl+v，完成粘贴功能
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(1000);
        // 发送消息
        try {
            sendMsg();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendMsg() throws InterruptedException {
        String s = HttpUtil.get("https://chp.shadiao.app/api.php");
        sendMsg(s+"[奸笑]");
    }

    private static void sendMsg(String msg) {
        // 创建Robot对象
        Robot robot = getRobot();
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 将字符串复制到剪切板
        Transferable tText = new StringSelection(msg);
        clip.setContents(tText, null);
        // 以下两行按下了ctrl+v，完成粘贴功能
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // 回车发送
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(1000);
    }

    private static Robot getRobot(){
        // 创建Robot对象
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return robot;
    }

    public static void main(String[] args) {
        String friendName = "李宇飞";
        for (int i=0;i<10;i++){
            searchPerson(friendName);
        }
    }

}