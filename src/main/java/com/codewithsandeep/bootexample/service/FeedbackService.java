package com.codewithsandeep.bootexample.service;

import java.util.List;

import com.codewithsandeep.bootexample.dto.FeedbackDto;

public interface FeedbackService {
	
	public FeedbackDto saveFeedback(FeedbackDto feedbackDto);
	
	public FeedbackDto updateFeedback(FeedbackDto feedbackDto, Long feedbackId);
	
	public List<FeedbackDto> getAllFeedback();
	
	public void deleteFeedback(Long feedbackId);

}
