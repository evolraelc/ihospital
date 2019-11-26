package com.ihospital.controller;

import entity.Result;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import tools.FastDFSClient;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: ihospital
 * @description: 图片上传
 * @author: Mr.King
 * @create: 2019-11-20 23:21
 **/

@RestController
public class UploadController {

//    @Value("${FILE_SERVER_URL}")
//    private String file_server_url;
//
//    @RequestMapping("/upload.do")
//    public Result upload(MultipartFile file){
//        String originalFilename = file.getOriginalFilename();
//        String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
//
//        try {
//            FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
//            String fileId = client.uploadFile(file.getBytes(), extName);
//
//            String url = file_server_url+fileId;
//            return new Result(true,url);
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(false,"Failed");
//        }
//
//    }


    @RequestMapping("/upload2.do")
    public Result upload2(MultipartFile file, HttpServletRequest request){

        //String path= "D:\\uploads\\";
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        File file1 = new File(path);
        if (!file1.exists()){
            file1.mkdirs();
        }
        String originalFilename = file.getOriginalFilename();
        String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        if (!extName.equals("jpg")&&!extName.equals("png")){
            return new Result(false,"Wrong format");
        }
        String uuid = UUID.randomUUID().toString().replace("-","");
        originalFilename = uuid+"_"+originalFilename;
        try {
            file.transferTo(new File(path,originalFilename));
            String fileUrl = "/uploads/" + originalFilename;
            //String fileUrl = "D://uploads/" + originalFilename;
            return new Result(true,fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,"Wrong size");
        }


//        try {
//            tools.FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
//            String fileId = client.uploadFile(file.getBytes(), extName);
//
//            String url = file_server_url+fileId;
//            return new Result(true,url);
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Result(false,"Failed");
//        }

    }


}
