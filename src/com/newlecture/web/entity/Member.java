package com.newlecture.web.entity;

import java.util.Date;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	private String birthday;
	private String phone;
	private Date regdate;
	private String boss;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String id, String pwd, String name, String gender, int age, String birthday, String phone,
			Date regdate, String boss) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.phone = phone;
		this.regdate = regdate;
		this.boss = boss;
	}
	
	public Member(String id, String pwd, String name, String gender, int age, String birthday, String phone) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}
	
	
	
}
