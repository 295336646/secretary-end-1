package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import usts.cl.bean.File;
import usts.cl.service.FileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        return this.fileService.uploadFile(file, uid);
    }

    /**
     * 下载文件
     */
    @GetMapping("/down")
    @ResponseBody
    public void downFile(@RequestParam(value = "fileId") Integer fileId, HttpServletResponse response) {
        this.fileService.downFile(fileId, response);
    }

    @GetMapping("/downWordReview")
    @ResponseBody
    public void downWordReview(String sid, String sname, String cname, String advisorGrade,
                               String reviewGrade, String replyGrade, String total, String review,
                               HttpServletRequest request, HttpServletResponse response) {
        this.fileService.downWordReview(sid, sname, cname, advisorGrade,
                reviewGrade, replyGrade, total, review,
                request, response);
    }

    @GetMapping("/downWordSheet")
    @ResponseBody
    public void downWordSheet(String sid, String sname, String cname, String task,
                              String technology, String language, String answer, String replyGrade,
                              String comments,
                              HttpServletRequest request, HttpServletResponse response) {
        this.fileService.downWordSheet(sid, sname, cname, task,
                technology, language, answer, replyGrade,
                comments, request, response);
    }


}
