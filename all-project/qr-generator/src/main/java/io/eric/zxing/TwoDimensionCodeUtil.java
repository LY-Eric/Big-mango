package io.eric.zxing;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
/**
 * @author liuyang
 * @desc 背景颜色改变的二维码
 */
public class TwoDimensionCodeUtil {
	/*背景色,默认黑色*/
	private static  int foreColor = 0xFF000000;
	/*前景色，默认白色*/
	private static  int backColor = 0xFFFFFFFF;
 
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? foreColor : backColor);
			}
		}
		TwoDimensionCodeUtil.foreColor = 0xFF000000;
		TwoDimensionCodeUtil.backColor = 0xFFFFFFFF;
		return image;
	}
	
 
	public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}
 
	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}
/**
 * 
 * @param content内容
 * @param desPath目标图片路径
 * @param width长
 * @param height宽
 * @return
 */
	@SuppressWarnings("unchecked")
	public static boolean stringToImage(String content, String desPath, int width, int height) {
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			@SuppressWarnings("rawtypes")
			Hashtable hints = new Hashtable();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			System.out.println(desPath);
			File file1 = new File(desPath);
			if(!file1.exists()){
				File parent=file1.getParentFile();
					parent.mkdirs();
				file1.createNewFile();
			}
			MatrixToImageWriter.writeToFile(bitMatrix, "gif", file1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	public static boolean stringToImage(String content, String desPath, int width, int height,int backColor,int foreColor) {
		TwoDimensionCodeUtil.backColor=backColor;
		TwoDimensionCodeUtil.foreColor=foreColor;
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			@SuppressWarnings("rawtypes")
			Hashtable hints = new Hashtable();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			System.out.println(desPath);
			File file1 = new File(desPath);
			if(!file1.exists()){
				File parent=file1.getParentFile();
					parent.mkdirs();
				file1.createNewFile();
			}
			TwoDimensionCodeUtil.writeToFile(bitMatrix, "gif", file1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
 
	public static void main(String[] args) {
		String content = "测试";
		String path = "D:/book/数学/餐巾纸.jpg";
		String b="ff";
		int a=(int) Long.parseLong("FFFF0000", 16);
		TwoDimensionCodeUtil.stringToImage(content, path, 500, 500, a, 0xff7d7d7d);
		System.out.println(a);
		System.out.println(0xffe1e1e1);
	}
}
