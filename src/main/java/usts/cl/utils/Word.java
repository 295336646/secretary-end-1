package usts.cl.utils;

import lombok.Cleanup;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;

import java.io.*;
import java.util.Map;

public class Word {

    /**
     * 实现对word修改操作
     *
     * @param filePath  word模板路径
     * @param fileName  生成的word文件名称
     * @param reference 模板名称
     * @param map       待填充的数据，从数据库读取
     */
    public static void write(String filePath, String fileName, String reference, Map<String, String> map) {
        try {
            // 读取模板文件
            File file = new File(filePath + reference);
            FileInputStream in = new FileInputStream(file);

            // 通过输入流加载word模板
            HWPFDocument hdt = new HWPFDocument(in);
            // 获取文档的读取范围，除页眉和页脚
            Range range = hdt.getRange();
            // 替换文本内容
            map.forEach((key, value) -> range.replaceText(key, value));
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                range.replaceText(entry.getKey(), entry.getValue());
//            }
            ByteArrayOutputStream ostream = new ByteArrayOutputStream();
            // 创建新文件目录
            File newFile = new File(filePath + map.get("${1}"));
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            // 第一个参数：文件路径
            // 第二个参数：ture为文件末尾追加内容
            //           false为覆盖原文件
            // 默认false
            FileOutputStream out = new FileOutputStream(filePath + map.get("${1}") + "/" + fileName, false);
            // 输出字节流
            hdt.write(ostream);
            out.write(ostream.toByteArray());
            out.close();
            ostream.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
