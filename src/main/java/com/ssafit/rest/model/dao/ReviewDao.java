package com.ssafit.rest.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafit.rest.model.dto.Review;

@Mapper
public interface ReviewDao {
	public abstract List<Review> selectAllByVideoId(String videoId);

	public abstract Review selectOne(int id);

	public abstract int insertReview(Review review);

	public abstract int updateReview(Review review);

	public abstract int deleteReview(int id);
}
