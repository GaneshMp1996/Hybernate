
package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "COllage")
public class Collage {
	@Id
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc",strategy = "increment")
	@Column(name = "COLLAGE_ID")
	private int collageId;
	
	@Column(name = "COLLAGE_NAME")
	private String collageName;
	
	@OneToMany(targetEntity = Student.class,
	mappedBy = "collage",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Student> students;
	
	public Collage() {
		// TODO Auto-generated constructor stub
	}

	public Collage(int collageId, String collageName, List<Student> students) {
		super();
		this.collageId = collageId;
		this.collageName = collageName;
		this.students = students;
	}

	public int getCollageId() {
		return collageId;
	}

	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Collage [collageId=" + collageId + ", collageName=" + collageName + ", students=" + students + "]";
	}
	
}
