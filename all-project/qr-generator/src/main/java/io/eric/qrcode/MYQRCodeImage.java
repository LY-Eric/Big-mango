package io.eric.qrcode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

public class MYQRCodeImage implements QRCodeImage {

	BufferedImage bufferedImage;

	public MYQRCodeImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public int getHeight() {
		return bufferedImage.getHeight();
	}
	@Override
	public int getPixel(int arg0, int arg1) {
		return bufferedImage.getRGB(arg0, arg1);
	}
	@Override
	public int getWidth() {
		return bufferedImage.getWidth();
	}

}
