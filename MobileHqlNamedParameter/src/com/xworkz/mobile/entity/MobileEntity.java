package com.xworkz.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import org.hibernate.id.IncrementGenerator;
@Table(name= "laptop.mobile")
@Entity
public class MobileEntity implements java.io.Serializable {
	@Id
	@Column(name = "MOBILE_ID")

	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")

	private int mobile_Id;

	@Column(name = "MOBILE_BRAND")
	private String mobile_Brand;

	@Column(name = "MOBILE_PRICE")
	private double mobile_price;

	@Column(name = "ROM")
	private String rom;

	@Column(name = "COLOR")
	private String color;

	@Column(name = "CAMERA_SIZE")
	private int camera_Size;

	@Column(name = "IS_FINGERPRINT_SUPPORTED")
	private boolean is_FingerPrint_Supported;

	@Column(name = "OS_TYPE")
	private String os_Type;

	public MobileEntity() {
		super();
		IncrementGenerator generator = new IncrementGenerator();

	}

	public MobileEntity(String mobile_Brand, double mobile_price, String rom, String color, int camera_Size,
			boolean is_FingerPrint_Supported, String os_Type) {
		super();
		// this.mobile_Id = mobileId;
		this.mobile_Brand = mobile_Brand;
		this.mobile_price = mobile_price;
		this.rom = rom;
		this.color = color;
		this.camera_Size = camera_Size;
		this.is_FingerPrint_Supported = is_FingerPrint_Supported;
		this.os_Type = os_Type;
	}

	public int getMobileId() {
		return mobile_Id;
	}

	public void setMobileId(int mobileId) {
		this.mobile_Id = mobileId;
	}

	public String getMobile_Brand() {
		return mobile_Brand;
	}

	public void setMobile_Brand(String mobile_Brand) {
		this.mobile_Brand = mobile_Brand;
	}

	public double getMobile_price() {
		return mobile_price;
	}

	public void setMobile_price(double mobile_price) {
		this.mobile_price = mobile_price;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCamera_Size() {
		return camera_Size;
	}

	public void setCamera_Size(int camera_Size) {
		this.camera_Size = camera_Size;
	}

	public boolean isIs_FingerPrint_Supported() {
		return is_FingerPrint_Supported;
	}

	public void setIs_FingerPrint_Supported(boolean is_FingerPrint_Supported) {
		this.is_FingerPrint_Supported = is_FingerPrint_Supported;
	}

	public String getOs_Type() {
		return os_Type;
	}

	public void setOs_Type(String os_Type) {
		this.os_Type = os_Type;
	}

	@Override
	public String toString() {
		return "MobileEntity [mobileId=" + mobile_Id + ", mobile_Brand=" + mobile_Brand + ", mobile_price="
				+ mobile_price + ", rom=" + rom + ", color=" + color + ", camera_Size=" + camera_Size
				+ ", is_FingerPrint_Supported=" + is_FingerPrint_Supported + ", os_Type=" + os_Type + "]";
	}

}
