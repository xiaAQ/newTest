package com.xiahaolei.utils.PDFUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;


/**
 * pdf水印工具类
 *
 * @author Mark sunlightcs@gmail.com
 */
public class PdfWatermark {
    public static byte[] watermarkPdf(byte[] pdfBuf, String mark) throws Exception {
        if (StringUtils.isBlank(mark)) {
            return pdfBuf;
        }

        PdfReader reader = new PdfReader(pdfBuf);
        // 修改后的PDF将会存入bao
        ByteArrayOutputStream bao = new ByteArrayOutputStream(pdfBuf.length);
        try {
            PdfStamper stamper = new PdfStamper(reader, bao);

            // 字体设置支持中文    Base- Font.EMBEDDED(参数的第三个字段的值   )
            BaseFont font = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);

            int total = reader.getNumberOfPages() + 1;
            PdfContentByte under;

            for (int i = 1; i < total; i++) {
                Rectangle pageRect = stamper.getReader().getPageSizeWithRotation(i);
                // 获得PDF最顶层
                under = stamper.getOverContent(i);
                under.saveState();
                // 设置透明度为0.3
                PdfGState gs = new PdfGState();
                gs.setFillOpacity(0.3f);
                under.setGState(gs);
                // 开始加入水印
                under.beginText();
                under.setFontAndSize(font, 25);
                under.setColorFill(BaseColor.GRAY);
                // 每个水印最新间隔120，随着字数边长，间隔增加
                int between;
                if (mark.length() <= 8) {
                    between = 120;
                } else {
                    between = 120 + (mark.length() - 8) * 20;
                }
                int xMax = (int) Math.ceil(pageRect.getWidth() / between);
                int yMax = (int) Math.ceil(pageRect.getHeight() / between);
                for (int x = 0; x <= xMax + 1; x++) {
                    for (int y = 1; y <= yMax + 1; y++) {
                        // 水印文字成45度角倾斜
                        under.showTextAligned(Element.ALIGN_LEFT, mark, x * between, y * between, 45);
                    }
                }
                // 添加水印文字结束
                under.endText();
                under.setLineWidth(1f);
                under.stroke();
            }

            stamper.close();
            pdfBuf = bao.toByteArray();
            return pdfBuf;
        } catch (Exception e) {
            // log.error(“bao关闭异常”, e);
        } finally {
            if (null != bao) {
                try {
                    bao.flush();
                    bao.close();
                } catch (IOException e) {
                    // log.error(“bao关闭异常”, e);
                }

            }
        }
        return pdfBuf;
    }
}