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
	
}
