package com.ic.base;

import com.ic.entity.red.RedPackage;

import java.util.Date;

/**
 * Created by perxin on 2016/11/25 11:24 11:24.
 */
public class RedPackageTest extends Thread{

    public void run() {
        for (int i = 1; i < 100; i++) {
            RedPackage redPackage = new RedPackage();
            System.out.print("===============" + i + "==============");
            redPackage.test();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Date());
        RedPackageTest test = new RedPackageTest();
        test.start();
        System.out.println(new Date());
    }
}


