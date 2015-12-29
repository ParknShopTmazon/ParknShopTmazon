package com.tmazon.dao;

import java.util.List;

import com.tmazon.domain.Message;

public interface MessageDao {

	public List<Message> findByIds(Integer userId, Integer friendId);
	
	public boolean insert(Message message);
	
	public boolean updateUnreadByIds(Integer userId, Integer friendId, Boolean isUnread);
	
}
