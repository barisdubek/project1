package com.kocfinans.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="montly_income_list")
public class MontlyIncomeList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "explanation")
	private String explanation;
	
	@Column(name = "income_rate")
	private String incomeRate;
	
	public MontlyIncomeList() {}

	public MontlyIncomeList(long id, String explanation, String incomeRate) {
		super();
		this.id = id;
		this.explanation = explanation;
		this.incomeRate = incomeRate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getIncomeRate() {
		return incomeRate;
	}

	public void setIncomeRate(String incomeRate) {
		this.incomeRate = incomeRate;
	}
	
	

}
