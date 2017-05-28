package com.main.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country {
	
	@Id
	@Column(name="country_id")
	@SequenceGenerator(name="countrySeq", sequenceName="country_Seq", allocationSize=1)
	@GeneratedValue(generator="countrySeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="country_name")
	private String countryName;

	public Country(int id, String countryName) {
		super();
		this.id = id;
		this.countryName = countryName;
	}

	public Country() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
