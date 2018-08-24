package io.eric.qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author liuyang
 * @create 2018-08-09 10:49
 * @desc
 */
public class ImageModify{
    public static void imageModify() throws Exception{
//读取图片
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\work\\pro_workspace\\Big-mango\\all-project\\qr-generator\\img\\amin.jpg"));
        //字节流转图片对象
        Image bi =ImageIO.read(in);
        //获取图像的高度，宽度
        int height=bi.getHeight(null);
        int width =bi.getWidth(null);
        //构建图片流
//        BufferedImage tag = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);
        BufferedImage tag = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
        //绘制改变尺寸后的图
//        tag.getGraphics().drawImage(bi, 0, 0,width / 2, height / 2, null);
        tag.getGraphics().drawImage(bi, 0, 0,640, 640, null);
        //输出流
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\copy.jpg"));
        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        //encoder.encode(tag);
        ImageIO.write(tag, "JPG",out);
        in.close();
        out.close();
        //转字节流
        //ByteArrayOutputStream out = new ByteArrayOutputStream();

        //ImageIO.write(tag, "PNG",out);
        //InputStream is = new ByteArrayInputStream(out.toByteArray());
    }

    public static void main(String[] args) {

        try {
            imageModify();
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
