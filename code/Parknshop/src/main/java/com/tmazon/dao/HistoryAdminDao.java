package com.tmazon.dao;

import java.sql.Date;
import java.util.List;

import com.tmazon.domain.Order;

public interface HistoryAdminDao {
	
	public List<Order> search(Date start,Date end);
	
}

