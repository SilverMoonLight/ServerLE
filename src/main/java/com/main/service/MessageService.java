package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.dataentity.Message;
import com.main.repo.MessageRepo;

public class MessageService implements MessageServiceInterface {

	@Autowired
	MessageRepo messageRepo;
	
	@Override
	public void createMessage(Message message) {
		messageRepo.save(message);
	}

}
