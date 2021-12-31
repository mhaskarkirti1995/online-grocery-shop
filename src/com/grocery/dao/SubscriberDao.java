package com.grocery.dao;

import java.util.List;

import com.grocery.pojo.Subscriber;

public interface SubscriberDao
{
	boolean addSubscriber(Subscriber subscribe);
	List<Subscriber> displayAllSubscriber();//admin
	
}
