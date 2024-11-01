package com.ssafit.rest.model.service;

import java.util.List;

import com.ssafit.rest.model.dto.Video;

public interface VideoService {
	
	List<Video> getTopViewedVideos();
	List<Video> getVideosByPart(String part);
}
