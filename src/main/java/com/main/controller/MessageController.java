package com.main.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.main.dataentity.Message;
import com.main.service.MessageServiceInterface;
import com.main.transferobject.MessageTO;

@RestController
public class MessageController {

	private Logger logger = Logger.getLogger(MessageController.class);
	
	@Autowired
	MessageServiceInterface messageService;
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public void createMessage(@RequestBody MessageTO messageTO) {
		logger.info("Entering create message endpoint");
		Message message = new Message(messageTO.getSender(), messageTO.getSubject(), messageTO.getMessage());
		messageService.createMessage(message);
		logger.info("message was saved");
	}
}
