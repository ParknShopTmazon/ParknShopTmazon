package com.tmazon.domain;

public class Rate {
	private double rateNum;
	private String rate;
	
	
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getRate() {
		return rate;
	}
	public void setRateNum(double rateNum) {
		this.rateNum = rateNum;
	}
	public double getRateNum() {
		
		if(rate == null || rate.equals(""))
		{
			System.out.println("Error::Rate::getRateNum::RateStr is null");
			return 0.0;
		}
		else
		{
			return Double.valueOf(rate);
		}
	}
	
}
