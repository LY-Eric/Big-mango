package io.eric.qrcode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateQACode {

	public static void main(String[] args) throws Exception {
		Qrcode x = new Qrcode();
		// 纠错等级
		x.setQrcodeErrorCorrect('M');
		// N代表数字,A代表a-Z,B代表其它字符
		x.setQrcodeEncodeMode('B');
		// 版本
		x.setQrcodeVersion(7);

		String qrData = "www.imooc.com";
		int width = 67 + 12 * (7 - 1);
		int height = 67 + 12 * (7 - 1);

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D gs = bufferedImage.createGraphics();

		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);

		// 偏移量
		int pixoff = 2;

		// 如果转换的内容有汉字
		byte[] d = qrData.getBytes("gb2312");
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
		}
		gs.dispose();
		bufferedImage.flush();
		ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));
	}
}
