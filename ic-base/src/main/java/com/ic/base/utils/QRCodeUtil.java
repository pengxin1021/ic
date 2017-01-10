package com.ic.base.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class QRCodeUtil {

	/**
	 * 生成二维码
	 * @param content
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage genetateQRCode(String content, int width, int height) {
		Hashtable<Object, Object> hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BufferedImage bi = null;
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
			bi = MatrixToImageWriter.toBufferedImage(bitMatrix);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return bi;
	}
	
	public static void main(String[] args) {
		BufferedImage bi = genetateQRCode("www.baidu.com", 300, 300);
		ImageUtil.bufferedImageToFile(bi, "c:\\", "a");
	}
}
