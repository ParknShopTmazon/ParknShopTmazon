package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Message;

public interface MessageDao {

	public List<Message> select(Message message, boolean twoWay);
	
	public boolean insert(Message message);
	
	public boolean updateUnreadByIds(Integer userId, Integer friendId, Boolean isUnread);
	
}
