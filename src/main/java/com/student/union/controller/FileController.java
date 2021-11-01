package com.student.union.controller;

import com.student.union.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {
    String path="D:\\桌面下载\\union\\src\\main\\resources\\static\\images";
    // 处理文件上传
    @PostMapping(value = "/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile[] files) {
        List<String> paths=new ArrayList<>();
        JsonResult result=null;
        //获取文件在服务器的储存位置
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        if(files !=null && files.length>0){
            for(int i=0;i<files.length;i++){
                //获取原始文件名称(包含格式)
                String originalFileName= files[i].getOriginalFilename();
                System.out.println("原始文件名称：" + originalFileName);
                //获取文件类型，以最后一个`.`为标识
                String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                System.out.println("文件类型：" + type);
                //获取文件名称（不包含格式）
                String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
                //设置文件新名称: 当前时间的毫秒数+文件名称（不包含格式）
                String fileName = System.currentTimeMillis()+ "." + type;
                System.out.println("新文件名称：" + fileName);
                //在指定路径下创建一个文件
                File targetFile = new File(path, fileName);
                try {
                    files[i].transferTo(targetFile);
                    paths.add("/"+fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    result=new JsonResult(500,"上传异常");
                    break;
                }
            }
        }else {
            result=new JsonResult(404,"没有上传文件");
        }
        if(paths !=null && paths.size()>0){
            result=new JsonResult(200,"已上传成功的文件",paths);
        }
        return result;
    }

}
