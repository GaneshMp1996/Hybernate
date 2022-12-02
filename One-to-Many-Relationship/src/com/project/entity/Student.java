package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "students")
public class Student {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")
	private int id;
	@Column(name = "NAME")
	private String name;
	@ManyToOne
	@JoinColumn(name = "collage_id")

	private Collage collage;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String name, Collage collage) {
		super();
		this.id = id;
		this.name = name;
		this.collage = collage;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Collage getCollage() {
		return collage;
	}


	public void setCollage(Collage collage) {
		this.collage = collage;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", collage=" + collage + "]";
	}
	

}
