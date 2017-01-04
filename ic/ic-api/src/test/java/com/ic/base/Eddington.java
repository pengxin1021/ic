package com.ic.base;

import java.io.IOException;
import java.util.Scanner;

public class Eddington {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Scanner scan1 = new Scanner(System.in);
		String str = scan1.nextLine();
		
		int[] num = strToIntArry(str);
		
		for(int i = 0; i < N; i ++) {
			if(num[i] < i) {
				System.out.println(num[i-1]);
				break;
			}
		}
	}
	
	private static int[] strToIntArry(String str) {
		String[] strArr = str.split(" ");
		int[] num = new int[strArr.length];
		for(int i = 0; i < num.length; i ++) {
			num[i] = Integer.valueOf(strArr[i]);
		}
		for(int i = 0; i < num.length -1; i ++) {
			for(int j = i + 1; j < num.length; j ++) {
				if(num[i] < num[j]){
					int t = num[i];
					num[i] = num[j];
					num[j] = t;
				}
			}
		}
		return num;
	}
	
}
