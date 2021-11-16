package com.xworkz.mobile.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.singlesessionfactory.SessionFactoryProvider;

public class MobileDaoImpl implements MobileDao {

	@Override
	public void saveMobileRecords() {
		System.out.println("INVOKED SAVE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			MobileEntity mobileEntity = new MobileEntity("Redmi", 12000.00, "6GB", "Blue", 23, false, "Android");
			// MobileEntity mobileEntity = new MobileEntity("Lyf", 15000.00, "4GB",
			// "LightBlue", 12, true, "Android");

			session.save(mobileEntity);
			// session.save(mobileEntity8);
			System.out.println("Done");

			transaction.commit();

		} catch (Exception e) {
			System.out.println("inside catch block !!!");
			transaction.rollback();
		} finally {
			if (session != null) {

				session.close();
				System.out.println(" session is closed");

			} else {

				System.out.println("session is not closed");

			}
		}

	}

	@Override
	public void getMobileEntity() {
		System.out.println("INVOKED GET MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 0);

			System.out.println("read is done" + mobileEntity);

			// SessionFactoryProvider.closeSessionFactory();
		} catch (Exception e) {

			System.out.println("inside catch block!!!");

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
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

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 3);

			System.out.println("MobileEntity" + mobileEntity);

			mobileEntity.setMobile_Brand("Redmi");
			mobileEntity.setOs_Type("Android");
			mobileEntity.setColor("GREY");

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

		}

	}

	public void deleteMobileEntity() {
		System.out.println("INVOKED DELETE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 4);

			System.out.println("MobileEntity" + mobileEntity);

			transaction = session.beginTransaction();

			session.delete(mobileEntity);

			transaction.commit();

			System.out.println("delete");

			SessionFactoryProvider.closeSessionFactory();

		} catch (Exception e) {

			System.out.println("inside catch block!!!");
			transaction.rollback();

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}

	}

}
