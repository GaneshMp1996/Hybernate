package com.xworkz.mobiletester;

import com.xworkz.mobile.impl.MobileDao;
import com.xworkz.mobile.impl.MobileDaoImpl;

public class MobileTester {
	public static void main(String[] args) {
		MobileDao mobiledaoImpl = new MobileDaoImpl();

		//		mobiledaoImpl.saveMobileRecords();
		//		mobiledaoImpl.getMobileEntity();
		//		mobiledaoImpl.updateMobileEntity();
		mobiledaoImpl.deleteMobileEntity();

	}

}
