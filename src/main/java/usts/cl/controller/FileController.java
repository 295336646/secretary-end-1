package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import usts.cl.bean.File;
import usts.cl.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("/cl")
public class FileController {
    @Autowired
    FileService fileService;

    /**
     * 测试
     * 文件上传
     */
    @PostMapping("/upload/{uid}")
    @ResponseBody
    public File upload(@RequestParam(value = "file", required = false) MultipartFile file,
                       @PathVariable("uid") String uid) {
        File fileDomain = new File();
        //上传
        try {
            String rawFileName = file.getOriginalFilename();
            String fileName = rawFileName.substring(0, file.getOriginalFilename().lastIndexOf("."));
            String fileType = rawFileName.substring(file.getOriginalFilename().lastIndexOf("."));
            fileDomain.setFileName(fileName);
            fileDomain.setFileType(fileType);
            fileDomain.setFile(file.getBytes());
            fileDomain.setUid("152040135202");
            fileService.uploadFile(fileDomain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileDomain;
    }

    /**
     * 下载文件
     */
    @GetMapping("/down")
    @ResponseBody
    public void downFile(@RequestParam(value = "fileId") Integer fileId, HttpServletResponse response) {
        try {
            File file = fileService.downFile(fileId);
            byte[] fileStream = file.getFile();
            String fileName = file.getFileName();
            String fileType = file.getFileType();
            // 以流的形式下载文件
            //设置下载文件使用的报头
            response.reset();
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + toUTF8String(fileName + fileType));
            OutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(fileStream);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载保存时中文文件名字符编码转换方法
     */
    public String toUTF8String(String str) {
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            //取出字符中的每个字符
            char c = str.charAt(i);
            //Unicode码值在0-255之间，不作处理
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {//转换UTF-8编码
                byte b[];
                try {
                    b = Character.toString(c).getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    b = null;
                }
                //转换为%HH的字符串形式
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) {
                        k &= 255;
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
}
