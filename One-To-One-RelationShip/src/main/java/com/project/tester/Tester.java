package com.project.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Person;
import com.project.entity.PersonDetail;

public class Tester {
	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure("Hibernate.cfg.xml").configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		PersonDetail personDetail=new PersonDetail();
		personDetail.setIncome(15000);
		personDetail.setJob("Java devoloper");
		personDetail.setZipCode("577589");
		Person ganesh=new Person();
		ganesh.setPersonName("GAnesh");
		ganesh.setPersonDetail(personDetail);
		PersonDetail personDetail2=new PersonDetail();
		personDetail2.setIncome(30000);
		personDetail2.setJob("Senier Software Devoloper");
		personDetail2.setZipCode("577001");
		Person person=new Person();
		person.setPersonName("Guru Prasad");
		person.setPersonDetail(personDetail2);
		
//		personDetail.setPersonDetailId(12134);
//		session.save(ganesh);
		session.save(person);
		session.getTransaction().commit();
		System.out.println("Saved");
		
		
		
	}

}
