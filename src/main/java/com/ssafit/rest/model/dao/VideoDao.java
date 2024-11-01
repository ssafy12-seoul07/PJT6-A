package com.ssafit.rest.model.dao;

import java.util.List;

import com.ssafit.rest.model.dto.Video;

public interface VideoDao {
	List<Video> selectTopViewedVideos();
	List<Video> selectVideosByPart(String part);
}
