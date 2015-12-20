package com.tmazon.util;
//税率工具类
public class Rate {
	private static float rate=(float) 0.05;//默认税率为0.05

	public static float getRate() {
		return rate;
	}

	public static void setRate(int rate) {
		Rate.rate = rate;
	}
}
