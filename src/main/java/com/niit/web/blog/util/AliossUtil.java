package com.niit.web.blog.util;

import com.aliyun.oss.OSSClient;

import java.io.File;
import java.util.UUID;

/**
 * @author Liang
 * @ClassName AliossUtil
 * @Description TODO
 * @Date 2019/11/6
 * @Version 1.0
 **/
public class AliossUtil {
    public static String ossUpload(File file){
        String bucketDomain="http://niit-soft.oss-cn-hangzhou.aliyuncs.com/";
        String endpoint="oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId="LTAI4FqtpVB2psh6jvg1peZd";
        String accessKeySecret="WTuXhQkDWWuaS5UnzA35hhydVyBn6d";
        String bucketName="niit-soft";
        String filedir="avatar/";
        String fileName=file.getName();
        System.out.println(fileName);
        String fileKey= "liangliang"+fileName.substring(fileName.indexOf("."));
        OSSClient ossClient=new OSSClient(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(bucketName,filedir+fileKey,file);
        StringBuffer url=new StringBuffer();
        url.append(bucketDomain).append(filedir).append(fileKey);
        ossClient.shutdown();
        return url.toString();
    }
    public static  void main(String[] args){
        File file=new File("D:/tupian/01.png");
        String url =ossUpload(file);
        System.out.println(url);
    }
}

