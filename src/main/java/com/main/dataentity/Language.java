package com.main.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Language")
public class Language {

	@Id
	@Column(name="language_id")
	@SequenceGenerator(name="languageSeq", sequenceName="language_Seq", allocationSize=1)
	@GeneratedValue(generator="languageSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="language_name")
	private String languageName;

	public Language(int id, String languageName) {
		super();
		this.id = id;
		this.languageName = languageName;
	}

	public Language() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", languageName=" + languageName + "]";
	}
	
	
}
