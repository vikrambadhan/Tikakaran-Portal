package com.tikakaran.entity;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class UserEntity {
	
	@Id String uId;
	@Index
	String password ;
	@Index
	String cName;
@Index
	String fName;
@Index	
String mName;
@Index	
String Month;
@Index	
String Day;
@Index	
String Year;
@Index	
String mobile;
@Index
String emailid;
	


	public UserEntity() {

	}

	

	public UserEntity( String cName, String fName,
			String mName, String Month, String Day, String Year, String mobile,String emailid,String uId, String password) {
		super();
		this.uId = uId;
		this.password = password;
		this.cName = cName;
		this.fName = fName;
		this.mName = mName;
		this.Month=Month;
		this.Day=Day;
		this.Year=Year;
		this.mobile = mobile;
		this.emailid=emailid;
	}



	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}



	public String getMonth() {
		return Month;
	}



	public void setMonth(String month) {
		Month = month;
	}



	public String getDay() {
		return Day;
	}



	public void setDay(String day) {
		Day = day;
	}



	public String getYear() {
		return Year;
	}



	public void setYear(String year) {
		Year = year;
	}



	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getmName() {
		return mName;
	}



	public void setmName(String mName) {
		this.mName = mName;
	}



	



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getuId() {
		return uId;
	}



	public void setuId(String uId) {
		this.uId = uId;
	}



	

		
}
