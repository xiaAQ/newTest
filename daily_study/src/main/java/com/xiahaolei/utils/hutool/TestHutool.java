package com.xiahaolei.utils.hutool;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.util.IOUtils;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author AiQ
 * @date 2021/1/8
 * @describe:
 */
public class TestHutool {

        @Test
        public  void test() throws Exception{
        File file = new File("D:\\债权数据.xlsx");

        FileInputStream input = new FileInputStream(file);

        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        // 1.获取上传文件输入流
        InputStream inputStream = null;
        try{
            inputStream = multipartFile.getInputStream();
        }catch (Exception e){
        }
        // 2.应用HUtool ExcelUtil获取ExcelReader指定输入流和sheet
        ExcelReader excelReader = ExcelUtil.getReader(inputStream, "基本信息");
        // 可以加上表头验证
        // 3.读取第二行到最后一行数据
        List<List<Object>> read = excelReader.read(2, excelReader.getRowCount());
        for (List<Object> objects : read) {
        // 获取指定的的数据

        }
    }
}
