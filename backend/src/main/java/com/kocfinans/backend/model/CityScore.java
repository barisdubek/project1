package com.kocfinans.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="city_score")
public class CityScore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "city_code")
	private String cityCode;
	
	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "city_score")
	private String cityScore;
	
	public CityScore() {}

	public CityScore(long id, String cityCode, String cityName, String cityScore) {
		super();
		this.id = id;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.cityScore = cityScore;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityScore() {
		return cityScore;
	}

	public void setCityScore(String cityScore) {
		this.cityScore = cityScore;
	}
	
	

}
