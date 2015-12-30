package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.MessageDao;
import com.tmazon.domain.Message;
import com.tmazon.service.MessageService;
import com.tmazon.util.BasicFactory;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao = BasicFactory.getImpl(MessageDao.class);
	
	public List<Message> find(Message message, boolean twoWay) {
		return messageDao.select(message, twoWay);
	}

	public boolean createMessage(Message message) {
		return messageDao.insert(message);
	}
	
	public boolean setMessagesReaded(int fromId, int toId) {
		return messageDao.updateUnreadByIds(fromId, toId, false);
	}

	public int getUnreadCount(Message message, boolean twoWay) {
		message.setIsUnread(true);
		List<Message> messages = find(message, twoWay);
		return messages == null ? 0 : messages.size();
	}

}
