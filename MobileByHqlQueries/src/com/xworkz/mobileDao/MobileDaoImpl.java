package com.xworkz.mobileDao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.singlesessionfactory.SessionFactoryProvider;

public class MobileDaoImpl implements MobileDao {

	@Override
	public void getAllMobileEntity() {
		System.out.println("INVOKED GET ALL MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "from com.xworkz.mobile.entity.MobileEntity";

			org.hibernate.query.Query query = session.createQuery(hqlquery);

			List listOfMobileEntity = query.list();

			System.out.println(listOfMobileEntity);

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
	public void getMobileEntity() {
		System.out.println("INVOKED GET MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 6);

			System.out.println("read is done " + mobileEntity);

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

	public void deleteMobileEntity() {
		System.out.println("INVOKED DELETE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 0);

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

	public void updateMobileEntity() {
		System.out.println("INVOKED UPDATE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			MobileEntity mobileEntity = session.get(MobileEntity.class, 5);

			System.out.println("MobileEntity" + mobileEntity);

			mobileEntity.setMobile_Brand("Redmi");
			mobileEntity.setOs_Type("Android");
			mobileEntity.setColor("GREY");

			transaction = session.beginTransaction();

			session.update(mobileEntity);

			transaction.commit();

			System.out.println("Updated Sucessfully");

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

	public void getMobileBrandByID() {
		System.out.println("INVOKED GET MOBILE BRAND BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "select mobile. mobile_Brand from MobileEntity as mobile  where MOBILE_ID=1 ";
			// or
			//				 String hqlquery = "select mobile_Brand from MobileEntity where MOBILE_ID=1 ";

			org.hibernate.query.Query query = session.createQuery(hqlquery);

			Object object = query.uniqueResult();

			System.out.println("mobileBrand without type casting:" + object);

			String mobileBrand = (String) object;

			System.out.println("mobileBrand withtype casting:" + mobileBrand);

			System.out.println(mobileBrand);

		} catch (HibernateException e) {

		} finally {

			if (session != null) {
				System.out.println("session closed");
			} else {
				System.out.println("session is not closed");
			}

		}

	}

	public void getMobileEntityByID() {
		System.out.println("INVOKED GET MOBILE ENTITY BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "from MobileEntity where MOBILE_ID=3 ";

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

	@Override
	public void updateMobilePriceByID() {
		System.out.println("INVOKED UPDATE MOBILE PRICE BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			session.beginTransaction();

			String hqlquery = "update MobileEntity set mobile_Price='10000' where MOBILE_ID=5";

			org.hibernate.query.Query query = session.createQuery(hqlquery);

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

	public void deleteMobileEntityByID() {
		System.out.println("INVOKED DELETE MOBILE ENTITY BY ID");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			session.beginTransaction();

			String hqlquery = "delete from MobileEntity where MOBILE_ID=20";

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

	public void maxMobileEntityByMobilePrice() {
		System.out.println("INVOKED MAX MobileEntity By MobilePrice");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "select max(mobile_price) from MobileEntity";

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

	public void avgMobileEntityByMobilePrice() {
		System.out.println("INVOKED AVG MobileEntity By MobilePrice");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "select avg(mobile_price) from MobileEntity";

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

	public void sumMobileEntityByMobilePrice() {
		System.out.println("INVOKED SUM MobileEntity By MobilePrice");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "select sum(mobile_price) from MobileEntity";

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

	public void countMobileEntityBYCameraSize() {
		System.out.println("INVOKED COUNT MobileEntity BY CameraSize");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			session = sessionFactory.openSession();

			String hqlquery = "select count(*)from MobileEntity where CAMERA_SIZE =10";

			org.hibernate.query.Query query = session.createQuery(hqlquery);

			List listOfMobileEntity = query.list();

			System.out.println(listOfMobileEntity);

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
	public void saveMobileEntity() {
		System.out.println("INVOKED SAVE MOBILE ENTITY");
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;

		try {

			sessionFactory = SessionFactoryProvider.getSessionFactory();

			// sessionFactory = new Configuration().configure("hibernatemobiles.cfg.xml")
			// .addAnnotatedClass(MobileEntity.class).buildSessionFactory();

			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			/*
			 * MobileEntity mobileEntity1 = new MobileEntity(1, "realme", 20000.00, "8GB",
			 * "Blue", 7, false, "Android"); MobileEntity mobileEntity2 = new
			 * MobileEntity(2, "Iphone", 98000.00, "16GB", "Silver", 10, true, "IOS");
			 * MobileEntity mobileEntity3 = new MobileEntity(3, "Oneplus", 45000.00, "16GB",
			 * "Black", 10, false,"Android"); MobileEntity mobileEntity4 = new
			 * MobileEntity(4, "Samsung", 35000.00, "8GB", "White", 10, true, "Android");
			 * MobileEntity mobileEntity5 = new MobileEntity(5, "Redmi", 20000.00, "6GB",
			 * "Red", 10, false, "Android"); session.save(mobileEntity1);
			 * session.save(mobileEntity2); session.save(mobileEntity3);
			 * session.save(mobileEntity4); session.save(mobileEntity5);
			 */
			MobileEntity mobileEntity6 = new MobileEntity("MicroMax", 20000.00, "8GB", "Blue", 7, false, "Android");
			session.save(mobileEntity6);
			transaction.commit();
			// System.out.println("row inserted");

			// SectionFactoryProvider.closeSessionFactory();

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
			/*
			 * if (sessionFactory != null) { sessionFactory.close();
			 * System.out.println(" sessionFactory is closed"); } else {
			 * System.out.println("sessionFactory is not closed"); }
			 */
		}
	}

}
