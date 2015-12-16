package com.tmazon.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtil {
	private DaoUtil() {}

	private static DataSource source = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return source;
	}
	
	public static Connection getConnection() {
		try {
			return source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
