package com.xworkz.mobile.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.mobile.MobileEntity;

public class MobileDaoImpl implements MobileDao {

	@Override
	public void saveMobileEntity() {
		System.out.println("INVOKED SAVE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(MobileEntity.class);

			configuration.configure("Hybernate.cfg.xml");

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			session.beginTransaction();

			MobileEntity mobileEntity = new MobileEntity(5, "Vivo", 35000.00, "16GB", "Blue", 10, false, "Android");
			MobileEntity mobileEntity1 = new MobileEntity(6, "Vivo", 35000.00, "16GB", "Blue", 10, false, "Android");
			MobileEntity mobileEntity2 = new MobileEntity(7, "Vivo", 35000.00, "16GB", "Blue", 10, false, "Android");
			MobileEntity mobileEntity3 = new MobileEntity(8, "Vivo", 35000.00, "16GB", "Blue", 10, false, "Android");
			MobileEntity mobileEntity4 = new MobileEntity(9, "Vivo", 35000.00, "16GB", "Blue", 10, false, "Android");
			session.save(mobileEntity);
			System.out.println("Done");
			session.save(mobileEntity1);
			session.save(mobileEntity2);
			session.save(mobileEntity3);
			session.save(mobileEntity4);

			session.getTransaction().commit();
			System.out.println("Query  inserted Sucessfully");
		} catch (Exception e) {
			System.out.println("inside catch block !!!");
		} finally {
			if (session != null) {

				session.close();
				System.out.println(" session is closed");

			} else {

				System.out.println("session is not closed");

			}
			if (sessionFactory != null) {

				sessionFactory.close();
				System.out.println(" sessionFactory is closed");
			} else {

				System.out.println("sessionFactory is not closed");

			}

		}

	}

	@Override
	public void getMobileEntity() {
		System.out.println("INVOKED GET MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(MobileEntity.class);

			configuration.configure("Hybernate.cfg.xml");

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 1);

			System.out.println("read is done" + mobileEntity);

		} catch (Exception e) {

			System.out.println("inside catch block!!!");

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sessionFactory != null) {
				System.out.println("sessionFactory is closed");
			} else {
				System.out.println("sessionFactory is not closed");
			}
		}
	}

	@Override
	public void updateMobileEntity() {
		System.out.println("INVOKED UPDATE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {

			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(MobileEntity.class);

			configuration.configure("Hybernate.cfg.xml");

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 4);

			System.out.println("MobileEntity" + mobileEntity);

			mobileEntity.setMobile_Brand("lenovo");
			mobileEntity.setOs_Type("BlackBerry");
			mobileEntity.setColor("Blue");

			transaction = session.beginTransaction();

			session.update(mobileEntity);

			transaction.commit();

			System.out.println("Update");

		} catch (Exception e) {

			System.out.println("inside catch block!!!");
			transaction.rollback();

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sessionFactory != null) {
				System.out.println("sessionFactory is closed");
			} else {
				System.out.println("sessionFactory is not closed");
			}
		}

	}

	@Override
	public void deleteMobileEntity() {
		System.out.println("INVOKED DELETE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {

			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(MobileEntity.class);

			configuration.configure("Hybernate.cfg.xml");

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 2);

			System.out.println("MobileEntity" + mobileEntity);

			transaction = session.beginTransaction();

			session.delete(mobileEntity);

			transaction.commit();

			System.out.println("delete");

		} catch (Exception e) {

			System.out.println("inside catch block!!!");
			transaction.rollback();

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sessionFactory != null) {
				System.out.println("sessionFactory is closed");
			} else {
				System.out.println("sessionFactory is not closed");
			}
		}

	}
}
