package com.tmazon.util;

import com.tmazon.dao.RateDao;

public class RateUtil {
	private static double rate;
	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		RateUtil.rate = rate;
	}
}
