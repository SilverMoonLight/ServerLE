package com.main.transferobject;

import java.io.Serializable;

import com.main.dataentity.Role;

public class ClientSearchTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3369577464172349167L;

	private String email;
	private String language;
	private String country;
	private int startAge;
	private int endAge;

	public ClientSearchTO(String email, String language, String country, int startAge, int endAge) {
		super();
		this.email = email;
		this.language = language;
		this.country = country;
		this.startAge = startAge;
		this.endAge = endAge;
	}

	public ClientSearchTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getStartAge() {
		return startAge;
	}

	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}

	public int getEndAge() {
		return endAge;
	}

	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}

	@Override
	public String toString() {
		return "ClientSearchTO [email=" + email + ", language=" + language + ", country=" + country + ", startAge="
				+ startAge + ", endAge=" + endAge + "]";
	}

}
