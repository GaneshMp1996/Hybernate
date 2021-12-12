package com.xworkz.mobile.Dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDao {
	void getMobileBrandByID(int MOBILE_ID);
	void saveMobileEntity(MobileEntity mobileEntity);
	void getMobileEntityByID(int MOBILE_ID);
	void updateMobilePriceByID(int MOBILE_ID, double mobile_price);
	void deleteMobileEntityByID(int MOBILE_ID);
	void minMobileEntityByMobilePrice() ;



}
