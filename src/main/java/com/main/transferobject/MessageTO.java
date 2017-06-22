package com.main.transferobject;

import java.io.Serializable;

import com.main.dataentity.Client;

public class MessageTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6758240192956163016L;
	private Client sender;
	private String subject;
	private String body;
	
	public MessageTO() {
	}

	public MessageTO(Client sender, String subject, String message) {
		this.sender = sender;
		this.subject = subject;
		this.body = message;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return body;
	}

	public void setMessage(String message) {
		this.body = message;
	}
	
	

}
