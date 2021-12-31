package com.grocery.dao;

import java.util.List;

import com.grocery.pojo.Contact;

public interface ContactDao 
{
	boolean addContact(Contact contact);
	List<Contact> displayAllContact();
}
