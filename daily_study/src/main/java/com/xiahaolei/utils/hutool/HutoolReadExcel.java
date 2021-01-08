package com.xiahaolei.utils.hutool;


import cn.hutool.http.ContentType;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

public class HutoolReadExcel {
    @Test
    public void test() throws IOException {
        File pdfFile = new File("D://债权数据.xlsx");
        FileInputStream fileInputStream = new FileInputStream(pdfFile);
        MultipartFile multipartFile = new MockMultipartFile(pdfFile.getName(), pdfFile.getName(),
                ContentType.FORM_URLENCODED.toString(), fileInputStream);
        // 1.获取上传文件输入流
        InputStream inputStream = null;
        try{
            inputStream = multipartFile.getInputStream();
        }catch (Exception e) {
        }
        // 2.应用HUtool ExcelUtil获取ExcelReader指定输入流和sheet
        ExcelReader excelReader = ExcelUtil.getReader(inputStream, "基本信息");
        // 可以加上表头验证
        // 3.读取第二行到最后一行数据
        List<List<Object>> read = excelReader.read(2, excelReader.getRowCount());
        for (List<Object> objects : read) {
        // objects.get(0),读取某行第一列数据
        // objects.get(1),读取某行第二列数据
        }
    }
}

