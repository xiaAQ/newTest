package com.xiahaolei.utils.PDFUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.net.FileNameMap;
import java.net.URLConnection;

/**
 * @author Xiahaolei
 * @date 2020/11/15
 * @describe:
 */
@Slf4j
public class Test {
    /**
     * PDF水印渲染
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/watermarkPdf")
    public ResponseEntity<byte[]> watermarkPdf(@RequestParam MultipartFile file) {
        byte[] byteArray;
        try {
            String mark = "水印测试";
            byteArray = PdfWatermark.watermarkPdf(file.getBytes(), mark);
        } catch (Exception e) {
            String msg = "加水印失败：" + e.getMessage();
            log.error(msg);
            return new ResponseEntity(msg.getBytes(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        HttpHeaders headers = new HttpHeaders();
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String mimeType = fileNameMap.getContentTypeFor(file.getOriginalFilename());
        if (null != mimeType) {
            headers.add("Content-Type", mimeType);
        }
        return new ResponseEntity(byteArray, headers, HttpStatus.OK);
    }
}
