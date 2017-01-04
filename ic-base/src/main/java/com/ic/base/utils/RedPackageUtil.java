package com.ic.base.utils;

import java.math.BigDecimal;

public class RedPackageUtil {

	public static void main(String[] args) {
		double a = 131.83;
		double b = 23.63;
		double c = a - b;
		double d = new BigDecimal(a).subtract(new BigDecimal(b)).doubleValue();
		System.out.println(c);
		System.out.println("d=====" + d);
	}
}
