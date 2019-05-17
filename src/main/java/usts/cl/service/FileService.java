package usts.cl.service;

import com.sun.istack.internal.Nullable;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import usts.cl.bean.File;
import usts.cl.bean.Group;
import usts.cl.bean.Teacher;
import usts.cl.dao.FileMapper;
import usts.cl.dao.GroupMapper;
import usts.cl.utils.Excel;
import usts.cl.utils.Word;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileService {
    @Autowired
    FileMapper fileMapper;


    public File downFile(Integer fileId) {
        return fileMapper.selectByPrimaryKey(fileId);
    }

    /**
     * @param file 获取上传的文件
     * @param uid  获取上传的用户
     * @return
     */
    public File uploadFile(MultipartFile file,
                           String uid) {
        File fileDomain = new File();
        //上传
        try {
            String rawFileName = file.getOriginalFilename();
            String fileName = rawFileName.substring(0, file.getOriginalFilename().lastIndexOf("."));
            String fileType = rawFileName.substring(file.getOriginalFilename().lastIndexOf("."));
            fileDomain.setFileName(fileName);
            fileDomain.setFileType(fileType);
            fileDomain.setFile(file.getBytes());
            fileDomain.setUid(uid);
            fileMapper.insertSelective(fileDomain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileDomain;
    }


    /**
     * @param fileId   通过数据库文件id下载文件
     * @param response
     */
    public void downFile(Integer fileId, HttpServletResponse response) {
        try {
            File file = downFile(fileId);
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
     * 下载答辩分组表
     *
     * @param request
     * @param response
     */
    public void downGroupSheet(HttpServletRequest request, HttpServletResponse response, List<Group> groupList, List<Group> groups) {
        String filePath = request.getServletContext().getRealPath("uploadfiles/");

        //筛选出答辩组长
        groupList.forEach(group -> {
            groups.forEach(group1 -> {
                if (group.getGroupnum().equals(group1.getGroupnum())) {
                    Teacher teacher = new Teacher();
                    teacher.setTname(group1.getTjudgename());
                    group.setTeacher(teacher);
                }
            });
        });
        Excel.write(filePath, groupList);
        downSheet(filePath, "答辩分组表.xlsx", response);
    }

    public void downSheet(String realpath, String fileName, HttpServletResponse response) {
        FileInputStream in; //输入流
        ServletOutputStream out; //输出流
        //设置下载文件使用的报头
        response.setHeader("Content-Type", "application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename="
                + toUTF8String(fileName));
        // 读入文件
        try {
            in = new FileInputStream(realpath + fileName);
            //得到响应对象的输出流，用于向客户端输出二进制数据
            out = response.getOutputStream();
            out.flush();
            int aRead;
            byte b[] = new byte[1024];
            while ((aRead = in.read(b)) != -1 & in != null) {
                out.write(b, 0, aRead);
            }
            out.flush();
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载答辩评议书
     */
    public void downWordReview(String sid, String sname, String cname, String advisorGrade,
                               String reviewGrade, String replyGrade, String total, String review,
                               HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap();
        map.put("${1}", sid);
        map.put("${2}", sname);
        map.put("${3}", cname);
        map.put("${4}", advisorGrade);
        map.put("${5}", reviewGrade);
        map.put("${6}", replyGrade);
        map.put("${7}", total);
        map.put("${8}", review);
        String realpath = request.getServletContext().getRealPath("uploadfiles/");
        String fileName = sname + "_" + sid + "_答辩评议书" + ".doc";
        String reference = "李子晗_14200107135_答辩评议书.doc";
        Word.write(realpath, fileName, reference, map);
        down(realpath, fileName, sid, response);
    }

    /**
     * 下载答辩评分表
     */
    public void downWordSheet(String tname, String sid, String sname, String cname, String task,
                              String technology, String language, String answer, String replyGrade,
                              String comments,
                              HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap();
        map.put("${1}", sid);
        map.put("${2}", sname);
        map.put("${3}", cname);
        map.put("${4}", task);
        map.put("${5}", technology);
        map.put("${6}", language);
        map.put("${7}", answer);
        map.put("${8}", replyGrade);
        map.put("${9}", comments);
        map.put("${10}", tname);
        String realpath = request.getServletContext().getRealPath("uploadfiles/");
        String fileName = sname + "_" + sid + "_评阅人评分表" + ".doc";
        String reference = "李子晗_14200107135_评阅人评分表.doc";
        Word.write(realpath, fileName, reference, map);
        down(realpath, fileName, sid, response);
    }

    public void down(String realpath, String fileName, String sid, HttpServletResponse response) {
        FileInputStream in; //输入流
        ServletOutputStream out; //输出流
        //设置下载文件使用的报头
        response.setHeader("Content-Type", "application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename="
                + toUTF8String(fileName));
        // 读入文件
        try {
            in = new FileInputStream(realpath + sid + "/" + fileName);
            //得到响应对象的输出流，用于向客户端输出二进制数据
            out = response.getOutputStream();
            out.flush();
            int aRead;
            byte b[] = new byte[1024];
            while ((aRead = in.read(b)) != -1 & in != null) {
                out.write(b, 0, aRead);
            }
            out.flush();
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
