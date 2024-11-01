package com.ssafit.rest.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Review {
	private int reviewId;
	private int userId;
	private int parentId;
	private List<Review> childReviews;
	private String videoId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime modifedAt;

	public Review() {
	}

	public Review(int userId, String videoId, String content) {
		this.userId = userId;
		this.videoId = videoId;
		this.parentId = 0;
		this.content = content;
	}
	
	public Review(int userId, String videoId, int parentId, String content) {
		this.userId = userId;
		this.videoId = videoId;
		this.parentId = parentId;
		this.content = content;
	}

	public Review(int reviewId, int userId, String videoId, int parentId, List<Review> childReviews, String content, LocalDateTime createdAt,
			LocalDateTime modifedAt) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.videoId = videoId;
		this.parentId = parentId;
		this.childReviews = childReviews;
		this.content = content;
		this.createdAt = createdAt;
		this.modifedAt = modifedAt;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifedAt() {
		return modifedAt;
	}

	public void setModifedAt(LocalDateTime modifedAt) {
		this.modifedAt = modifedAt;
	}

}
