package com.tmazon.service;

import java.util.List;

import com.tmazon.domain.Message;

public interface MessageService {

	public List<Message> find(Message message, boolean twoWay);
	
	public boolean createMessage(Message message);
	
	public int getUnreadCount(Message message, boolean twoWay);
	
	public boolean setMessagesReaded(int fromId, int toId);
	
}
