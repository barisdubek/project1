package com.kocfinans.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "id_number")
	private String id_number;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "montly_income_id")
	private long montly_income_id;
	
	@Column(name = "city_code")
	private long city_code;
	
	@Column(name = "total_score")
	private long total_score;
	
	public User() {}

	public User(String id_number, String firstName, String lastName, String phone, long montly_income_id, long city_code) {
		super();
		this.id_number = id_number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.montly_income_id = montly_income_id;
		this.city_code = city_code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getMontly_income_id() {
		return montly_income_id;
	}

	public void setMontly_income_id(long montly_income_id) {
		this.montly_income_id = montly_income_id;
	}

	public long getCity_code() {
		return city_code;
	}

	public void setCity_code(long city_code) {
		this.city_code = city_code;
	}

	public long getTotal_score() {
		return total_score;
	}

	public void setTotal_score(long total_score) {
		this.total_score = total_score;
	}
}
