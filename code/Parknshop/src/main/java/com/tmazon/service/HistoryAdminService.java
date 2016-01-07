package com.tmazon.service;

import java.sql.Date;
import java.util.List;

import com.tmazon.domain.History;

public interface HistoryAdminService {
	public List<History> search(Date start,Date end);
}
