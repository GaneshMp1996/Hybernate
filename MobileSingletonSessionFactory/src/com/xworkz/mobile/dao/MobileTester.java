package com.xworkz.mobile.dao;

public class MobileTester {
	public static void main(String[] args) {

		MobileDao mobileDAOImpl = new MobileDaoImpl();

		mobileDAOImpl.saveMobileEntity();
		mobileDAOImpl.getMobileEntity();
		mobileDAOImpl.updateMobileEntity();
		mobileDAOImpl.deleteMobileEntity();
	}

}
