package com.tmazon.util;

import java.io.IOException;
import java.util.Properties;

public class BasicFactory {
	private BasicFactory() {
	}

	private static Properties properties = new Properties();
	static {
		try {
			properties.load(BasicFactory.class.getClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getImpl(Class<T> clazz) {
		try {
			String name = clazz.getName();
			String implName = properties.getProperty(name);
			return (T) Class.forName(implName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
