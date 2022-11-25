package com.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Person {
	@Id
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")
	@Column(name = "PERSON_ID")
	private int personId;
	@Column(name = "PERSON_NAME")
	private String personName;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "personDetail_FK")//this is the foriegn key we make in mysql database
//	@Column(name = "PERSON_DETAIL")
	private PersonDetail personDetail;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String personName, PersonDetail personDetail) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personDetail = personDetail;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personDetail=" + personDetail + "]";
	}

	
	

}
