package com.feedback.feedbackforum.service;

import com.feedback.feedbackforum.model.Feedback;
import com.feedback.feedbackforum.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    // Other methods
}
