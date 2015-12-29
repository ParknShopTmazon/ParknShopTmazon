package com.tmazon.domain;

import java.sql.Timestamp;

public class Message {

	private Integer messageId;
	private Integer userId;
	private Integer friendId;
	private String content;
	private Timestamp messageTime;
	private Boolean isUnread;
	
	public Message() {
	}

	public Message(Integer messageId, Integer userId, Integer friendId, String content,
			Timestamp messageTime, Boolean isUnread) {
		super();
		this.messageId = messageId;
		this.userId = userId;
		this.friendId = friendId;
		this.content = content;
		this.messageTime = messageTime;
		this.isUnread = isUnread;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}

	public Boolean getIsUnread() {
		return isUnread;
	}

	public void setIsUnread(Boolean isUnread) {
		this.isUnread = isUnread;
	}
	
}
