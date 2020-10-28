package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class FileUpload {

    @PostMapping("uploadFile")
    public List uploadFile(@RequestParam("files")MultipartFile [] files){
        List<String> list = new ArrayList<>(16);
        if(files.length <= 0){
            list.add("请选择文件！");
            return list;
        }
        for(MultipartFile file : files){
            String originalFileName = file.getOriginalFilename();
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID() + "." + suffix;
            String filePath = "D:/uploadFile/";
            File targetFile =  new File(filePath + fileName);
            if(!targetFile.getParentFile().exists()){
                targetFile.getParentFile().mkdir();
            }
            try{
                file.transferTo(targetFile);
                list.add(originalFileName);
            } catch (Exception e){
                log.info("文件上传失败", e.getMessage());
                e.printStackTrace();
            }
        }
        return list;
    }
}
