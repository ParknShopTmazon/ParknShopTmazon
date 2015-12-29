package com.tmazon.service.impl;

import java.util.List;

import com.tmazon.dao.MessageDao;
import com.tmazon.domain.Message;
import com.tmazon.service.MessageService;
import com.tmazon.util.BasicFactory;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao = BasicFactory.getImpl(MessageDao.class);
	
	public List<Message> findByIds(Integer userId, Integer friendId) {
		return messageDao.findByIds(userId, friendId);
	}

	public boolean createMessage(Message message) {
		return messageDao.insert(message);
	}
	
	public boolean setMessageReaded(Integer userId, Integer friendId) {
		return messageDao.updateUnreadByIds(userId, friendId, true);
	}

}
