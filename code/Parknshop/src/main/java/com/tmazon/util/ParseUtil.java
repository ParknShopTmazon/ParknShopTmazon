package com.tmazon.util;

import java.text.DecimalFormat;

public class ParseUtil {

	public static String Price2String(Double price) {
		
		if(price != null){
			DecimalFormat df = new DecimalFormat("######0.00");
			return df.format(price);
		}
		
		return null;
	}
	
	public static Integer String2Integer(String s, Integer defaultValue) {
		
		try
		{
			if (s == null || s.isEmpty())
			{
				return defaultValue;
			}
			Integer re = Integer.parseInt(s);
			return re;
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		return defaultValue;
		
	}
	
}
