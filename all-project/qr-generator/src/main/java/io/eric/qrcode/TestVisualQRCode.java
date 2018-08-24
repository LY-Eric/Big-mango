package io.eric.qrcode;

import java.awt.Color;
import java.io.IOException;

import org.junit.Test;

/**
 * @Title: TestVisualQRCode.java
 * @Package com.boat.visualqrcode
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 黄本豪
 * @date 2016年12月1日 下午3:29:53
 * @version V1.0
 */

public class TestVisualQRCode {

	private final String outPutPath = "D:\\";

	@Test
	public void testPOSITIONRECTANGLE() {
		String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
		try {
			VisualQRCode.createQRCode(url, "./img/copy.png", outPutPath + "POSITIONRECTANGLE.png", 'M', new Color(2, 85, 43), null, null, 67 + 12 * (7 - 1), true,
					VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_RECTANGLE, VisualQRCode.FILL_SHAPE_MODEL_RECTANGLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFILLCIRCLE() {
		String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
		try {
			VisualQRCode.createQRCode(url, "./img/amin.jpg", outPutPath+"FILLCIRCLE.png", 'M', new Color(2, 85, 43), null, null, null, true,
					VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE, VisualQRCode.FILL_SHAPE_MODEL_CIRCLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLARGEIMG(){
		String url = "http://blog.csdn.net/weixin_41279060/article/details/78961532";
		try {
			VisualQRCode.createQRCode(url, "./img/Andy.jpg", outPutPath+"Andy.png", 'M', new Color(170, 24, 67), 800, 420, 200, false,
					VisualQRCode.POSITION_DETECTION_SHAPE_MODEL_ROUND_RECTANGLE, VisualQRCode.FILL_SHAPE_MODEL_RECTANGLE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
