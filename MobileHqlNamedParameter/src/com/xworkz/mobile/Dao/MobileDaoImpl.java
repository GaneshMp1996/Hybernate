package com.xworkz.mobile.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.singlesessionfactory.SessionFactoryProvider;

public class MobileDaoImpl implements MobileDao {
	public void saveMobileEntity(MobileEntity mobileEntity) {
		System.out.println("INVOKED SAVE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			session.save(mobileEntity);
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
	public void getMobileBrandByID(int mobile_Id) {
		System.out.println("INVOKED GET MOBILE BRAND BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "select mobile_Brand from MobileEntity where mobile_Id=:MOBILE_ID";

			org.hibernate.query.Query query = session.createQuery(hqlquery);
			query.setParameter("MOBILE_ID", mobile_Id);

			Object object = query.uniqueResult();

			System.out.println("mobile_Brand without type casting:" + object);

			String mobile_Brand = (String) object;

			System.out.println("mobile_Brand withtype casting:" + mobile_Brand);

			System.out.println(mobile_Brand);

		} catch (HibernateException e) {

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}


	}



	@Override
	public void getMobileEntityByID(int MOBILE_ID) {
		System.out.println("INVOKED GET MOBILE ENTITY BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "from MobileEntity where mobile_Id=:MOBILE_ID";

			org.hibernate.query.Query query = session.createQuery(hqlquery);
			query.setParameter("MOBILE_ID", MOBILE_ID);

			Object object = query.uniqueResult();

			System.out.println("MobileEntity :" + object);

		} catch (HibernateException e) {

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}

	}



	@Override
	public void updateMobilePriceByID(int MOBILE_ID, double mobile_price) {
		System.out.println("INVOKED UPDATE MOBILE PRICE BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			session.beginTransaction();

			String hqlquery = "update MobileEntity set mobile_Price=:MOBILE_PRICE where mobile_Id=:MOBILE_ID";

			org.hibernate.query.Query query = session.createQuery(hqlquery);
			query.setParameter("MobileID", MOBILE_ID);
			query.setParameter("MobilePrice", mobile_price);

			int noOfRowsAffected = query.executeUpdate();

			session.getTransaction().commit();

			System.out.println("noOfRowsAffected :" + noOfRowsAffected);

		} catch (HibernateException e) {
			System.out.println("inside catch block");
			session.getTransaction().rollback();
			System.out.println("Transaction has been rolled back");

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}

	}



	@Override
	public void deleteMobileEntityByID(int MOBILE_ID) {
		System.out.println("INVOKED DELETE MOBILE ENTITY BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			session.beginTransaction();

			String hqlquery = "delete from MobileEntity where mobile_ID=7";

			org.hibernate.query.Query query = session.createQuery(hqlquery);

			int delete = query.executeUpdate();

			session.getTransaction().commit();

			System.out.println("delete:" + delete);

		} catch (HibernateException e) {
			System.out.println("inside catch block");
			session.getTransaction().rollback();
			System.out.println("Transaction has been rolled back");

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}
	}


	public void minMobileEntityByMobilePrice() {
		System.out.println("INVOKED MIN MobileEntity By MobilePrice");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "select min(mobile_price) from MobileEntity";

			org.hibernate.query.Query query = session.createQuery(hqlquery);

			Object object = query.uniqueResult();

			System.out.println("MobileEntity :" + object);

		} catch (HibernateException e) {

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}
	}
}



