package com.ssafit.rest.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafit.rest.model.dto.Video;

@Mapper
public interface VideoDao {
	List<Video> selectTopViewedVideos(Integer count);
	List<Video> selectVideosByPart(String part, Integer count);
}
