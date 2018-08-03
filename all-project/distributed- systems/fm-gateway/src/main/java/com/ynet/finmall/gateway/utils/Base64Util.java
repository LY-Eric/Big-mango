package com.ynet.finmall.gateway.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Base64Util {

	/**
     * 把经过压缩过的base64串解码解压并写入打磁盘中
     * @param base64 压缩过的base64串
     * @param fileName 文件名
     * @param path 路径地址
     */
    public static void decode(String base64, String fileName, String path) {
        //解码
        byte[] data = Base64.decodeBase64(base64);
        data = unZip(data);
        writeFile(data, fileName, path);
    }

    /**
     * 把base64串解码写入打磁盘中
     * @param base64 base64串
     * @param fileName 文件名
     * @param path 路径地址
     */
    public static void decodeNoZip(String base64, String fileName, String path) {
        //解码
        byte[] data = Base64.decodeBase64(base64);
        writeFile(data, fileName, path);
    }

    /**
     * 二进制文件写入文件
     * @param data 二进制数据
     * @param fileName 文件名
     * @param path 路径地址
     */
    public static void writeFile(byte[] data, String fileName, String path) {
        try
        {
            String url = path + "//" + fileName;
            FileUtils.writeByteArrayToFile(new File(url), data);
        }
        catch (IOException e)
        {
            System.out.println("写文件出错" + e);
        }
    }

    /**
     * 解壓Gzip
     * @param data
     * @return
     */
    public static byte[] unGZip(byte[] data){
        byte[] b = null;
        try{
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1)
            {
                baos.write(buf, 0, num);
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
            gzip.close();
            bis.close();
        }
        catch (Exception ex){
            System.out.println("解压数据流出错！！" + ex);
        }
        return b;
    }
    /***
     * 解压Zip
     *
     * @param data
     * @return
     */
    public static byte[] unZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ZipInputStream zip = new ZipInputStream(bis);
            while (zip.getNextEntry() != null) {
                byte[] buf = new byte[1024];
                int num = -1;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((num = zip.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, num);
                }
                b = baos.toByteArray();
                baos.flush();
                baos.close();
            }
            zip.close();
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }
    
    /**
     * 读取文件并压缩数据然后转Base64编码
     * @param pathName 图片的绝对路径地址
     * @return
     */
    public static String base64(String pathName) {
        byte[] data = getPicData(pathName);
        if (data == null) {
            return null;
        }
        byte[] zipData = zip(data,"a.zip");
        return Base64.encodeBase64String(zipData);
    }

    /**
     * 读取文件并转Base64编码（不压缩文件）
     * @param pathName 图片的绝对路径地址
     * @return
     */
    public static String base64NoZip(String pathName) {
        byte[] data = getPicData(pathName);
        if (data == null) {
            return null;
        }
        //byte[] zipData = gZip(data);
        return Base64.encodeBase64String(data);
    }

    /**
     * @description 获取图片的二进制数据
     * @param pathName 图片的绝对路径地址
     * @return
     */
    public static byte[] getPicData(String pathName) {
        byte[] data = null;
        try {
            FileInputStream fi = new FileInputStream(pathName);
            int length = fi.available();
            data = new byte[length];
            fi.read(data);
            fi.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    /***
     * @description 压缩GZip
     * @param data 要压缩的二进制数据
     * @return
     */
    public static byte[] gZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            b = bos.toByteArray();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }
    /***
     * 压缩Zip
     *
     * @param data
     * @return
     */
    public static byte[] zip(byte[] data,String fileName) {
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zip = new ZipOutputStream(bos);
            ZipEntry entry = new ZipEntry(fileName);
            entry.setSize(data.length);
            zip.putNextEntry(entry);
            zip.write(data);
            zip.closeEntry();
            zip.close();
            b = bos.toByteArray();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }
    public static void main(String[] args) {
//    	String fileName = "C:\\Users\\xuhui\\Desktop\\1.jpg";
//        String base64 = base64(fileName);
//        System.out.println("经过base64转码和压缩: " + base64);
//        decode(base64, "1.jpg", "e:\\");
        String s = base64NoZip("D:\\personal_credit_authorization.pdf");
        System.out.println("经过base64转码: " + s);
        decodeNoZip(s, "personal_credit_authorization.pdf", "e:\\");
    }
}
