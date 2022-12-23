package com.codewithsandeep.bootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsandeep.bootexample.dto.FeedbackDto;
import com.codewithsandeep.bootexample.payloads.ApiResponse;
import com.codewithsandeep.bootexample.service.FeedbackService;

@RestController
@RequestMapping("/feedbackApi")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/")
	public ResponseEntity<FeedbackDto> saveFeedback(@RequestBody FeedbackDto feedbackDto)
	{
		FeedbackDto saveFeedback = this.feedbackService.saveFeedback(feedbackDto);
		return new ResponseEntity<FeedbackDto>(saveFeedback,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{feedbackId}")
	public ResponseEntity<FeedbackDto> updateFeedback(@RequestBody FeedbackDto feedbackDto, @PathVariable Long feedbackId)
	{
		FeedbackDto updateFeedback = this.feedbackService.updateFeedback(feedbackDto, feedbackId);
		return new ResponseEntity<FeedbackDto>(updateFeedback, HttpStatus.OK);		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<FeedbackDto>> getAllFeedback()
	{
		List<FeedbackDto> allFeedback = this.feedbackService.getAllFeedback();
		return new ResponseEntity<List<FeedbackDto>>(allFeedback, HttpStatus.OK);
	}
	
	@DeleteMapping("/{feedbackId}")
	public ResponseEntity<ApiResponse> deleteFeedback(@PathVariable Long feedbackId)
	{
		this.feedbackService.deleteFeedback(feedbackId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Feedback Deleted Sucessfully !!!", true), HttpStatus.OK);
		
	}
}
