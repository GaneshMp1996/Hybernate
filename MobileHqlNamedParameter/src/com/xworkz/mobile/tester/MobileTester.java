package com.xworkz.mobile.tester;

import java.util.Scanner;

import com.xworkz.mobile.Dao.MobileDao;
import com.xworkz.mobile.Dao.MobileDaoImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileTester {
	public static void main(String[] args) {
		MobileDao mobiledaoimpl=new MobileDaoImpl();
		//		mobiledaoimpl.getMobileBrandByID(1);
		//		Scanner scanner = new Scanner(System.in);
		//		 System.out.println("Enter the Number:");
		//		 int mobile_Id =scanner.nextInt();
		//		OR
		//		  mobiledaoimpl.getMobileBrandByID(mobile_Id);
		//		 

		//		MobileEntity mobileentity=new MobileEntity("samsung", 33000.00, "8GB", "LightPink", 32, true, "Android");
		//		mobiledaoimpl.saveMobileEntity(mobileentity);
		//		
		//		MobileEntity mobileentity = new MobileEntity("vivo", 20000.00, "4GB","blue", 24,false,"Android");
		//		mobiledaoimpl.saveMobileEntity(mobileentity);

		//		mobiledaoimpl.getMobileEntityByID(6);
		//		OR
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("Enter the Number:"); int mobileId =scanner.nextInt();
		 * mobileDAOImpl.getMobileEntityByID(mobileId);
		 */
		//		mobiledaoimpl.updateMobilePriceByID(23, 60000);

		//		mobiledaoimpl.deleteMobileEntityByID(23);
		mobiledaoimpl.minMobileEntityByMobilePrice();

	}

}
