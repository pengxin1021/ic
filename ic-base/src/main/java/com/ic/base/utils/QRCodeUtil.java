package com.ic.base.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

public class QRCodeUtil {
	
	public static BufferedImage getQRCode(String content, int width, int height) {
		Hashtable<Object, Object> hints = new Hashtable<Object, Object>();
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
	
	public static void bufferedImageToFile(BufferedImage bi, String type, String path) {
		Long time = new Date().getTime();
		try {
			ImageIO.write(bi, type, new File(time + "." + type));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BufferedImage bi = getQRCode("www.baidu.com", 300, 300);
		bufferedImageToFile(bi, "png", null);
	}
}
