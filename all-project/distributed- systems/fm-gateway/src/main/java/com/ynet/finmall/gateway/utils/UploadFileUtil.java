package com.ynet.finmall.gateway.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadFileUtil {
    /**
     * @Description 上传base64文件，思路：首先将base64文件解码并临时保存至服务器，之后将其从服务器上传至阿里oss，返回文件路径
     * @Author 刘俊重
     * @Date 2018/1/8
     * @param fileText base64加密的字符串(不压缩)
     * @param suffix 文件后缀，不加.
     * @param locationTempUrl 文件临时保存路径
     * @return 文件上传路径
     */
	public static String uploadBase64Text(String fileText,String suffix,String locationTempUrl){
        String fileName = UUID.randomUUID().toString()+"."+suffix;
        Base64Util.decodeNoZip(fileText, fileName,locationTempUrl);
        File file = new File(locationTempUrl+fileName);
        String fileUrl = null;
        try {
            fileUrl = OSSClientUtil.getUrl(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileUrl;
    }
}
