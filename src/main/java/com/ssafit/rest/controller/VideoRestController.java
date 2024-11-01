package com.ssafit.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.rest.model.service.VideoService;

@RestController
@RequestMapping("/ssafit-api")
@CrossOrigin("*")
public class VideoRestController {
	
	@Autowired
	VideoService vs;
	
}
