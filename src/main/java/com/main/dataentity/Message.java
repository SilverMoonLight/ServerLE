package com.main.dataentity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message {
	
	@Id
	@Column(name="message_id")
	@SequenceGenerator(name="messageSeq", sequenceName="message_Seq", allocationSize=1)
	@GeneratedValue(generator="messageSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client sendor;
	
	@Column(name = "message-subject")
	private String subject;
	
	@Column(name = "message-body")
	private String body;

	public Message() {
	}

	public Message(int id, Client sendor, String subject, String body) {
		this.id = id;
		this.sendor = sendor;
		this.subject = subject;
		this.body = body;
	}

	public Message(Client sendor, String subject, String body) {
		this.sendor = sendor;
		this.subject = subject;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getSendor() {
		return sendor;
	}

	public void setSendor(Client sendor) {
		this.sendor = sendor;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sendor=" + sendor + ", subject=" + subject + ", body=" + body + "]";
	}
	
	
	
	
	
	
	
	

}
