package com.feedback.feedbackforum.controller;

import com.feedback.feedbackforum.model.Feedback;
import com.feedback.feedbackforum.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createFeedback(@RequestBody Feedback feedback) {
        try {
            feedbackService.saveFeedback(feedback);
            return new ResponseEntity<>("Feedback saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving feedback: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Other methods
}
