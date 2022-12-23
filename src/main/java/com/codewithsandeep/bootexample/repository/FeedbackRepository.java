package com.codewithsandeep.bootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsandeep.bootexample.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
