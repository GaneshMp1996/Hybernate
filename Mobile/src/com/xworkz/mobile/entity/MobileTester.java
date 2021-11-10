package com.xworkz.mobile.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xworkz.mobile.MobileEntity;

public class MobileTester {
	public static void main(String... values) {

		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(MobileEntity.class);

		configuration.configure("hybernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		MobileEntity mobileEntity = new MobileEntity(3, "iphone", 96000.00, "256GB", "Black", 12, true, "IOS");

		session.save(mobileEntity);
		System.out.println("Done");

		session.getTransaction().commit();

		session.close();

		sessionFactory.close();

	}
}
