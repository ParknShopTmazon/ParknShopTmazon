package com.seller.dao;

import java.sql.*;

import com.seller.vo.*;
public class AddShopinfoDao extends Dbcommon{
	public void addShopinfo(Shopinfo sf)
	{
		String sql="insert into shopinfo(CustomerName,ShopInfoName,ShopInfoDescription) values('"+sf.getCustomername()+"','"+sf.getShopinfoname()+"','"+sf.getShopinfodescription()+"')";
		noResultSet(sql);
		CloseConnection(getCon(), getRs(), getSt());
	}
	public ResultSet query(String name) {
		String sql="select * from shopinfo where customername='"+name+"' and status=0";
		returnResultSet(sql);
		return rs;
	}
	public ResultSet select(String name)
	{
		String sql="select* from shopinfo where customername='"+name+"' and status=1";
		returnResultSet(sql);
		return rs;
	}
}
