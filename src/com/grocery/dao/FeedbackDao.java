package com.grocery.dao;

import java.util.List;

import com.grocery.pojo.Feedback;

public interface FeedbackDao 
{
	boolean addFeedback(Feedback feedback);
	List<Feedback> displayAllFeedback();
}
