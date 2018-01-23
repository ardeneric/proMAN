package com.eric.proman.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class UserSuper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "firstname")
	protected String firstname;

	@Column(name = "lastname")
	protected String lastname;

	@Column(name = "username", unique = true)
	protected String username;

	@Column(name = "address")
	protected String address;

	@Column(name = "city")
	protected String city;

	@Column(name = "country")
	protected String country;

	@Column(name = "contact")
	protected String contact;

	protected String password;

	@Column(name = "createdBy")
	protected Integer createdBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return contact;
	}

	public void setPostalcode(String postalcode) {
		this.contact = postalcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public UserSuper(Integer id, String firstname, String lastname, String username, String address, String city,
			String country, String postalcode, String password, Integer createdBy) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.address = address;
		this.city = city;
		this.country = country;
		this.contact = postalcode;
		this.password = password;
		this.createdBy = createdBy;
	}

	public UserSuper() {

	}

}
