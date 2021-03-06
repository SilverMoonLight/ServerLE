package com.main.dataentity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Client")
public class Client {

	public Client() {
		super();
	}
	
	

	public Client(String email, String password, String firstName, String lastName, Role role, Country country,
			Language language, int age, String bio) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.country = country;
		this.language = language;
		this.age = age;
		this.bio = bio;
	}



	public Client(int id, String email, String password, String firstName, String lastName, Role role, Country country,
			Language language, int age, String bio) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.country = country;
		this.language = language;
		this.age = age;
		this.bio = bio;
	}



	@Id
	@Column(name = "client_id")
	@SequenceGenerator(name = "clientSeq", sequenceName = "client_Seq", allocationSize = 1)
	@GeneratedValue(generator = "clientSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "client_email", nullable = false, unique = true)
	private String email;

	@Column(name = "client_password", nullable = false)
	@Size(min = 6)
	private String password;

	@Column(name = "client_firstName", nullable = false)
	private String firstName;

	@Column(name = "client_lastName", nullable = false)
	private String lastName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id")
	private Language language;

	@Column(name = "client_age")
	@Max(140)
	@Min(0)
	private int age;

	@Column(name = "client_bio")
	private String bio;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Client [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", role=" + role + ", country=" + country + ", language=" + language + ", age=" + age
				+ ", bio=" + bio + "]";
	}

	
}
