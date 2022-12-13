package com.iit.bean;

import java.io.Serializable;

public class User implements Serializable{
	private String userid;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private String mno;
	private String preference;
	private int role;

	public User() {

	}

	public User(String userid, String password, String fname, String lname, String email, String mno, String preference,int role) {

		this.userid = userid;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mno = mno;
		this.preference = preference;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
