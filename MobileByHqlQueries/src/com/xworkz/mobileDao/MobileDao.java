package com.xworkz.mobileDao;

public interface MobileDao {
	void saveMobileEntity();

	void getAllMobileEntity();

	void getMobileEntity();

	void deleteMobileEntity();

	void updateMobileEntity();

	void getMobileBrandByID();

	void getMobileEntityByID();

	void updateMobilePriceByID();

	void deleteMobileEntityByID();

	void minMobileEntityByMobilePrice();

	void maxMobileEntityByMobilePrice();

	void avgMobileEntityByMobilePrice();

	void sumMobileEntityByMobilePrice();

	void countMobileEntityBYCameraSize();

}
