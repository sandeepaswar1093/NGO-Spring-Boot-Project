package com.codewithsandeep.bootexample.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsandeep.bootexample.dto.FeedbackDto;
import com.codewithsandeep.bootexample.exception.ResourceNotFoundException;
import com.codewithsandeep.bootexample.model.Feedback;
import com.codewithsandeep.bootexample.repository.FeedbackRepository;
import com.codewithsandeep.bootexample.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FeedbackDto saveFeedback(FeedbackDto feedbackDto) {
		Feedback feedback = this.modelMapper.map(feedbackDto, Feedback.class);
		Feedback saveFeedback = this.feedbackRepository.save(feedback);
		return this.modelMapper.map(saveFeedback, FeedbackDto.class);
	}

	@Override
	public FeedbackDto updateFeedback(FeedbackDto feedbackDto, Long feedbackId) {
		Feedback feedback = this.feedbackRepository.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("Feedback", "FeedbackId", feedbackId));
		feedback.setFeedbackName(feedbackDto.getFeedbackName());
		feedback.setFeedbackEmail(feedbackDto.getFeedbackEmail());
		feedback.setFeedbackSuggestion(feedbackDto.getFeedbackSuggestion());
		Feedback savedFeedback = this.feedbackRepository.save(feedback);

		return this.modelMapper.map(savedFeedback, FeedbackDto.class);
	}

	@Override
	public List<FeedbackDto> getAllFeedback() {
		List<Feedback> feedbackList = this.feedbackRepository.findAll();
		List<FeedbackDto> feedbackDtos = feedbackList.stream()
				.map((feedback) -> this.modelMapper.map(feedback, FeedbackDto.class)).collect(Collectors.toList());

		return feedbackDtos;
	}

	@Override
	public void deleteFeedback(Long feedbackId) {
		Feedback feedback = this.feedbackRepository.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("Feedback", "FeedbackId", feedbackId));
		this.feedbackRepository.delete(feedback);

	}

}
