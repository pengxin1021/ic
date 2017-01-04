package com.ic.entity.red;

import com.ic.base.utils.DoubleUtil;

import java.io.Serializable;
import java.util.Random;

public class RedPackage implements Serializable{

	private static final long serialVersionUID = -5882227034859769643L;

	private int remainSize;
	
	private double remainMoney;

	public RedPackage() {

	}

	public RedPackage(int remainSize, double remainMoney) {
		this.remainSize = remainSize;
		this.remainMoney = remainMoney;
	}

	public int getRemainSize() {
		return remainSize;
	}

	public void setRemainSize(int remainSize) {
		this.remainSize = remainSize;
	}

	public double getRemainMoney() {
		return remainMoney;
	}

	public void setRemainMoney(double remainMoney) {
		this.remainMoney = remainMoney;
	}
	
	public double getRandomMoney() {
		if(remainSize == 1) {
			remainSize --;
			return remainMoney;
		}
		Random random = new Random();
		double min = 0.01;
		double max = DoubleUtil.divide(remainMoney, remainSize, 2) * 2;
		double money = random.nextDouble() * max;
		money = money < min ? min : money;
		money = Math.floor(money * 100) / 100;
		remainSize --;
		remainMoney = DoubleUtil.sub(remainMoney, money);
		return money;
	}

	public void test() {
		RedPackage red = new RedPackage(10, 100);
		System.out.print(red + "    ");
		double count = 0;
		while(red.getRemainSize() > 0) {
			double money = red.getRandomMoney();
			System.out.print(money + "    ");
			count = DoubleUtil.sum(count, money);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		RedPackage red = new RedPackage(10, 100);
		double count = 0;
		while(red.getRemainSize() > 0) {
			double money = red.getRandomMoney();
			System.out.print(money + "	");
			count = DoubleUtil.sum(count, money);
		}
		System.out.println("\n" + count);
	}
	
	
}
