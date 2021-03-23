package com.xiahaolei.utils.easyExcel;

import com.alibaba.excel.EasyExcel;

import java.util.*;

/**
 * @author xiaQ
 * @version 1.0
 * @date 2021/3/22 10:24
 */
public class Export {
    private final static String EXL_FILE_PATH = "222";

    public static void main(String[] args) {
        // 模板存储位置
        String fileName = EXL_FILE_PATH.concat("test.xlsx");
// 表头
        List<List<String>> headList = new ArrayList<>();
        List<String> head0 = Arrays.asList("按揭分类");
        List<String> head1 = Arrays.asList("欠款分类");
        List<String> head3 = Arrays.asList("欠款金额小计");
        headList.add(head0);
        headList.add(head1);
        headList.add(head3);
// 内容
        List<List<Object>> list = new ArrayList<>();
        List<Object> list1 = Arrays.asList("{a}", "{b}", "{c}");
        list.add(list1);
// 这里有个参数inMemory(true),是为了解决生成模板后，填充时模板中的字段未替换，填充数据的时候不要使用该参数，可能会造成OOM
        EasyExcel.write(fileName).head(headList).inMemory(Boolean.TRUE).sheet("test").doWrite(list);
// 要填充的模板路径
        String templatePath = EXL_FILE_PATH.concat("test.xlsx");
        String filePath = EXL_FILE_PATH.concat("test_.xlsx");
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        EasyExcel.write(filePath).withTemplate(templatePath).sheet().doFill(map);
    }
}
