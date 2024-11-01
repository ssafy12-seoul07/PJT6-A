package com.ssafit.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.rest.model.dao.ReviewDao;
import com.ssafit.rest.model.dto.Review;

@RestController("/api/review")
public class ReviewController {
	private ReviewDao reviewDao;

	public ReviewController(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@GetMapping("/")
	public ResponseEntity<List<Review>> getList(@RequestParam("videoId") String videoId) {
		if (videoId == null) {
			return ResponseEntity.badRequest().build();
		}

		List<Review> list = reviewDao.selectAllByVideoId(videoId);
		if (list.size() == 0) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(list);
	}

	@GetMapping("/")
	public ResponseEntity<Review> getReview(@PathVariable int id) {
		Review review = reviewDao.selectOne(id);
		if (review == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(review);
	}

	@PostMapping()
	public ResponseEntity<Review> create(@RequestBody Review review) {
		int result = reviewDao.insertReview(review);
		if (result < 1) {
			return ResponseEntity.internalServerError().build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(review);
	}
	
	@PutMapping()
	public ResponseEntity<Review> update(@RequestBody Review review) {
		int result = reviewDao.updateReview(review);
		if (result < 1) {
			return ResponseEntity.internalServerError().build();
		}
		
		return ResponseEntity.ok(reviewDao.selectOne(review.getReviewId()));
	}
	
	@DeleteMapping()
	public ResponseEntity<?> delete(@PathVariable int reviewId) {
		int result = reviewDao.deleteReview(reviewId);
		if (result < 1) {
			return ResponseEntity.internalServerError().build();
		}
		
		return ResponseEntity.ok(null);
	}
}
