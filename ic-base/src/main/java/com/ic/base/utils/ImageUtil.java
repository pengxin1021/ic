package com.ic.base.utils;

import com.ic.base.exception.BusinessException;
import net.coobird.thumbnailator.Thumbnails;

import java.io.*;

/**
 * Created by perxin on 2017/1/6.
 */
public class ImageUtil {

    /**
     * 压缩图片
     * @param bytes
     * @param limitSize：限制大小，单位MB
     * @return
     */
    public static byte[] compressImage(byte[] bytes, double limitSize) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        long size = bytes.length;
        System.out.println(size);
        if (size >= limitSize * 1024 * 1024) {
            double scale = (limitSize * 1024 * 1024f) / size;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                Thumbnails.of(bais).scale(scale).outputQuality(scale).toOutputStream(baos);
                bytes = baos.toByteArray();
            } catch (IOException e) {
                throw new BusinessException();
            }
        }
        System.out.println(bytes.length);
        return bytes;
    }

    //测试
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\IMG_1258(1).png");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        byte[] buffer = bos.toByteArray();

        byte[] bytes = compressImage(buffer, 2);

        byte2File(bytes, "E:\\", "33.png");
    }

    //测试
    private static void byte2File(byte[] buf, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
