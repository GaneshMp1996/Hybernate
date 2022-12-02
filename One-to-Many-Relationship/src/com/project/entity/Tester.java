package com.project.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Tester {
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure("Hibernate.cfg.xml").configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Collage collage1=new Collage();
		collage1.setCollageName("Jain");
		
		Student student=new Student(1, "Ganesh", collage1);
		Student student2=new Student(2, "Rakesh", collage1);
		
		session.save(student);
		session.save(student2);
		session.save(collage1);
		session.getTransaction().commit();
		System.out.println("Data is saved");
	}

}
