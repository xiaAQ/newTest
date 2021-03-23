package com.xiahaolei.algorithm.test;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/3/14 14:28
 */
@Slf4j
public class CreateFile {
    private static String path = null;
    public static void main(String[] args) throws Exception {
        createDirectory();
    }
    public static void createDirectory() {
        path = "/usr/local/photo/" + LocalDate.now().toString().replace("-", "/") + "/";
        File personFile = new File(path);

        // 判断persons文件夹是否已创建,未创建则循环创建所有模块的文件夹
        personFile = new File(path + "persons/");
        if (!personFile.isFile()) {
            List<File> fileList = new ArrayList<>();
            fileList.add(personFile);
            fileList.add(new File(path + "car/"));
            //..........
            fileList.add(new File(path + "other/")); // 如果以上模块都不匹配则扔到other

            for (int i = 0; i < fileList.size(); i++) {
                fileList.get(i).mkdirs();
                log.info("创建文件夹: " + fileList.get(i).getName());
            }
        }
    }
}
