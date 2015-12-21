package com.tmazon.util;
//税率工具类
public class Rate {
	private static int rate=5;//默认税率为0.05

	public static int getRate() {
		return rate;
	}

	public static void setRate(int rate) {
		Rate.rate = rate;
	}
}
