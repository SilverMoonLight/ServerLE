package com.main.transferobject;

import java.io.Serializable;

import com.main.dataentity.Country;
import com.main.dataentity.Language;
import com.main.dataentity.Role;

public class ClientTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4774607525472619531L;
	
	private String email;
	private int age;
	private String password;
	private String firstName;
	private String lastName;
	private Role role;
	private String bio;
	
	private Country country;
	private Language language;
	
	
	public ClientTO() {
		super();
	}

	
	
	public ClientTO(String email, int age, String password, String firstName, String lastName, Role role, String bio, Country country, Language language) {
		super();
		this.email = email;
		this.age = age;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.bio = bio;
		this.country = country;
		this.language = language;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Country getCountry() {
		return country;
	}



	public void setCountry(Country country) {
		this.country = country;
	}



	public Language getLanguage() {
		return language;
	}



	public void setLanguage(Language language) {
		this.language = language;
	}

	
	
	

}
