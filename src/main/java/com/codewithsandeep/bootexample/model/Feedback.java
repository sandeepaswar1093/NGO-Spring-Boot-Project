package com.codewithsandeep.bootexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "feedback_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private Long feedbackId;
	
	@Column(name = "feedback_name")
	private String feedbackName;
	
	@Column(name = "feedback_email")
	private String feedbackEmail;
	
	@Column(name = "feedback_suggestion")
	private String feedbackSuggestion;

}
