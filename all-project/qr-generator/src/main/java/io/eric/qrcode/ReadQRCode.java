package io.eric.qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ReadQRCode {

	public static void main(String[] args) throws Exception {
		File file = new File("D:/qrcode.png");
		
		BufferedImage bufferedImage = ImageIO.read(file);
		
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		
		String result = new String(codeDecoder.decode(new MYQRCodeImage(bufferedImage)),"gb2312");
		
		System.out.println(result);
		
	}
}
