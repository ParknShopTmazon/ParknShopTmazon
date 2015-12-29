package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Message;

public interface MessageService {

	public List<Message> findByIds(Integer userId, Integer friendId);
	
	public boolean createMessage(Message message);
	
}
