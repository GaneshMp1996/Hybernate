package com.xworkz.mobile.tester;

import com.xworkz.mobileDao.MobileDao;
import com.xworkz.mobileDao.MobileDaoImpl;

public class MobileTester {
	public static void main(String[] args) {
		MobileDao mobiledaoImpl = new MobileDaoImpl();

		//		mobiledaoImpl.getAllMobileEntity();
		//		mobiledaoImpl.getMobileEntity();
		//		mobiledaoImpl.deleteMobileEntity();
		//		mobiledaoImpl.updateMobileEntity();
		//		mobiledaoImpl.getMobileBrandByID();
		//		mobiledaoImpl.getMobileEntityByID();
		//		mobiledaoImpl.updateMobilePriceByID();
		//		mobiledaoImpl.deleteMobileEntityByID();
		//		mobiledaoImpl.minMobileEntityByMobilePrice();
		//		mobiledaoImpl.maxMobileEntityByMobilePrice();
		//		mobiledaoImpl.avgMobileEntityByMobilePrice();
		//		mobiledaoImpl.sumMobileEntityByMobilePrice();
		//		mobiledaoImpl.countMobileEntityBYCameraSize();
		mobiledaoImpl.saveMobileEntity();
	}

}
