package com.ssafit.rest.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Review {
	private int reviewId;
	private String videoId;
	private int userId;

	private String content;

	private int parentReviewId;
	private List<Review> childReviews;
	private LocalDateTime createdAt;
	private LocalDateTime modifedAt;

	public Review() {
	}

	public Review(String videoId, int userId, String content) {
		this.videoId = videoId;
		this.userId = userId;
		this.content = content;
		this.setParentReviewId(0);
	}

	public Review(int userId, String videoId, String content, int parentId) {
		this.userId = userId;
		this.videoId = videoId;
		this.content = content;
		this.setParentReviewId(parentId);
	}

	public Review(int reviewId, String videoId, int userId, String content, int parentReviewId, List<Review> childReviews,
			LocalDateTime createdAt, LocalDateTime modifedAt) {
		this.reviewId = reviewId;
		this.videoId = videoId;
		this.userId = userId;
		
		this.content = content;
		
		this.setParentReviewId(parentReviewId);
		this.setChildReviews(childReviews);
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

	public int getParentReviewId() {
		return parentReviewId;
	}

	public void setParentReviewId(int parentReviewId) {
		this.parentReviewId = parentReviewId;
	}

	public List<Review> getChildReviews() {
		return childReviews;
	}

	public void setChildReviews(List<Review> childReviews) {
		this.childReviews = childReviews;
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
