package com.ssafit.rest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.rest.model.dao.VideoDao;
import com.ssafit.rest.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoDao vd;

	@Override
	public List<Video> getTopViewedVideos() {
		List<Video> result = vd.selectTopViewedVideos();
		return result;
	}

	@Override
	public List<Video> getVideosByPart(String part) {
		List<Video> result = vd.selectVideosByPart(part);
		return result;
	}
	
	
}
