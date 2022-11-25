package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PersonDetail {
	
	@Id
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")
	@Column(name = "detailId_PK")//this is the primary key
	private int personDetailId;
	@Column(name = "ZIP_CODE")
	private String zipCode;
	@Column(name = "JOB")
	private String job;
	@Column(name = "INCOME")
	private double income;
	
	public PersonDetail() {
		// TODO Auto-generated constructor stub
	}

	public PersonDetail(int personDetailId, String zipCode, String job, double income) {
		super();
		this.personDetailId = personDetailId;
		this.zipCode = zipCode;
		this.job = job;
		this.income = income;
	}

	public int getPersonDetailId() {
		return personDetailId;
	}

	public void setPersonDetailId(int personDetailId) {
		this.personDetailId = personDetailId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "PersonDetail [personDetailId=" + personDetailId + ", zipCode=" + zipCode + ", job=" + job + ", income="
				+ income + "]";
	}
	

}
