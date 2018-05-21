package com.yidu.mybatis.example.bean;

import java.util.Date;

public class User {
	private Integer userid;
	private String username;
	private String password;
	private Date birthday;
	private String gender;
	private String address;
	
	public User(){}
	
	public User(Integer userid, String username, String password,
			Date birthday, String gender, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [address=" + address + ", birthday=" + birthday
				+ ", gender=" + gender + ", password=" + password + ", userid="
				+ userid + ", username=" + username + "]";
	}

}
