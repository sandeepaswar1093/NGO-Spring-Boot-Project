package com.codewithsandeep.bootexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {

	private Long feedbackId;

	private String feedbackName;

	private String feedbackEmail;

	private String feedbackSuggestion;

}
