package com.tmazon.util;

import java.text.DecimalFormat;

import com.tmazon.domain.Comment;

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
	
	public static Integer String2Score(String s, Integer defaultValue) {
		Integer value = String2Integer(s, defaultValue);
		value = value > Comment.SCORE_MIN?value:Comment.SCORE_MIN;
		value = value < Comment.SCORE_MAX?value:Comment.SCORE_MAX;
		return value;
	}
	
}
