package com.main.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Message_Recipient")
public class MessageRecipient {
	
	@Id
	@Column(name="recipient_id")
	@SequenceGenerator(name="recipientSeq", sequenceName="recipient_Seq", allocationSize=1)
	@GeneratedValue(generator="recipientSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client recipient;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_id")
	private Message message;

	@Override
	public String toString() {
		return "MessageRecipient [id=" + id + ", recipient=" + recipient + ", message=" + message + "]";
	}
	
	

}
