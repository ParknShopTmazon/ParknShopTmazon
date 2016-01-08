package com.tmazon.dao;

import java.util.Date;
import java.util.List;

import com.tmazon.domain.Order;
import com.tmazon.domain.OrderInfo;

public interface HistoryAdminDao {
	
	public List<OrderInfo> search(Date start,Date end);
	
}

