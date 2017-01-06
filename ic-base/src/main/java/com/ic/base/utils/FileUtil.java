package com.ic.base.utils;

import java.io.*;

/**
 * Created by perxin on 2017/1/6.
 */
public class FileUtil {

    public static byte[] fileToByte() {
        return null;
    }

    public static void byteToFile() {

    }

    public static byte[] inputStreamToByte(InputStream inputStream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        try {
            while ((n = inputStream.read(buf)) != -1) {
                baos.write(buf, 0, n);
            }
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public static InputStream byteToInputStream() {
//        ByteArrayInputStream bais = new ByteArrayInputStream();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(0.0f / 0.0f);
    }
}
