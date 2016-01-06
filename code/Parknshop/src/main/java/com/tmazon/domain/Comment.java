package com.tmazon.domain;

import java.util.Date;

public class Comment {
	
	
	public static final int SCORE_MIN = 1;
	public static final int SCORE_MAX = 5;

	private Integer commentId;
	private Integer userId;
	private Integer productId;
	private String content;
	private Date commentTime;
	private Integer shopScore;
	private Integer productScore;
	private Integer deliveryScore;
	private Integer replyId;
	public Comment(Integer commentId, Integer userId, Integer productId, String content, Date commentTime,
			Integer shopScore, Integer productScore, Integer deliveryScore, Integer replyId) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.productId = productId;
		this.content = content;
		this.commentTime = commentTime;
		this.shopScore = shopScore;
		this.productScore = productScore;
		this.deliveryScore = deliveryScore;
		this.replyId = replyId;
	}
	
	
	
	public Comment(Integer commentId, Integer userId, Integer productId, String content, Date commentTime,
			Integer replyId) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.productId = productId;
		this.content = content;
		this.commentTime = commentTime;
		this.replyId = replyId;
	}



	public Comment(Integer commentId, Integer userId, Integer productId, String content, Date commentTime) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.productId = productId;
		this.content = content;
		this.commentTime = commentTime;
	}



	public Comment() {
		super();
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	
	public Integer getShopScore() {
		return shopScore;
	}
	public void setShopScore(Integer shopScore) {
		this.shopScore = shopScore;
	}
	public Integer getProductScore() {
		return productScore;
	}
	public void setProductScore(Integer productScore) {
		this.productScore = productScore;
	}
	public Integer getDeliveryScore() {
		return deliveryScore;
	}
	public void setDeliveryScore(Integer deliveryScore) {
		this.deliveryScore = deliveryScore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((replyId == null) ? 0 : replyId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (replyId == null) {
			if (other.replyId != null)
				return false;
		} else if (!replyId.equals(other.replyId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", productId=" + productId + ", content="
				+ content + ", commentTime=" + commentTime + ", replyId=" + replyId + "]";
	}
	
	
	
}
