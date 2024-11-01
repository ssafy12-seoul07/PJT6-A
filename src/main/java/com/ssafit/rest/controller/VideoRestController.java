package com.ssafit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.rest.model.dto.Video;
import com.ssafit.rest.model.service.VideoService;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class VideoRestController {
	
	@Autowired
	VideoService vs;
	
	// 조회수 많은 영상 출력
	@GetMapping("/most-viewed/{count}")
	public ResponseEntity<List<Video>> getTopViewedVideos(@PathVariable("count") int count) {
		List<Video> videos = vs.getTopViewedVideos(count);
		if (videos == null || videos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(videos, HttpStatus.OK);
	}
	
	// 운동부위별 영상 출력
	@GetMapping("/search/{part}/{count}")
	public ResponseEntity<List<Video>> getVideosByPart(@PathVariable("part") String part, @PathVariable("count") int count) {
		List<Video> videos = vs.getVideosByPart(part, count);
		if (videos == null || videos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(videos, HttpStatus.OK);
	}
}