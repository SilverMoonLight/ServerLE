package com.main.dataentity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy="userSent", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Client> composer;
	
	@ManyToMany(mappedBy="userReceived", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Client> recipient;

	
	
	public Message(int id, List<Client> composer, List<Client> recipient) {
		super();
		this.id = id;
		this.composer = composer;
		this.recipient = recipient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Client> getComposer() {
		return composer;
	}

	public void setComposer(List<Client> composer) {
		this.composer = composer;
	}

	public List<Client> getRecipient() {
		return recipient;
	}

	public void setRecipient(List<Client> recipient) {
		this.recipient = recipient;
	}
	
	
	
	

}
