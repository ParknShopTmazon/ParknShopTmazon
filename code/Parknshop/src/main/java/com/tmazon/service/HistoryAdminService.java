package com.tmazon.service;

import java.util.Date;
import java.util.List;

import com.tmazon.domain.History;
import com.tmazon.util.Page;

public interface HistoryAdminService {
	public List<History> search(Date start,Date end);
	public Page<History> page(List<History> historyList,int curPage,int next);
	public double getIncome(List<History> historyList);
}
