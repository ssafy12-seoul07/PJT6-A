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
	
	// count 없이 전체 조회
    @GetMapping("/most-viewed")
    public ResponseEntity<List<Video>> getTopViewedVideos() {
    	List<Video> videos = vs.getTopViewedVideos(null);
        if (videos == null || videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
	
    // count 있는 경우
    @GetMapping("/most-viewed/{count}")
    public ResponseEntity<List<Video>> getTopViewedVideos(@PathVariable Integer count) {
        List<Video> videos = vs.getTopViewedVideos(count);
        if (videos == null || videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
    
    // count 없이 부위별 조회
    @GetMapping("/search/{part}")
    public ResponseEntity<List<Video>> getVideosByPart(@PathVariable String part) {
        List<Video> videos = vs.getVideosByPart(part, null);
        if (videos == null || videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
	
    // count 있는 부위별 조회
    @GetMapping("/search/{part}/{count}")
    public ResponseEntity<List<Video>> getVideosByPart(@PathVariable String part, @PathVariable Integer count) {
        List<Video> videos = vs.getVideosByPart(part, count);
        if (videos == null || videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
}
