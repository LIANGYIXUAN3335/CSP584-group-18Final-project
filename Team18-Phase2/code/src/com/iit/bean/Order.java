package com.iit.bean;

import java.util.Date;

public class Order {
	private String orderid;
	private Integer productid;
	private String productname;
	private String userid;
	private String username;
	private String email;
	private String creditcard;
	private Integer orderquantity;
	private String state;
	private String city;
	private String street;
	private String mobile;
	private String zipcode;
	private String createtime;
	private Double totalamount;

	public Order() {
	}

	public Order(String orderid, Integer productid, String productname, String userid, String username, String email, String creditcard, Integer orderquantity,String state, String city, String street, String mobile, String zipcode, String createtime, Double totalamount) {
		this.orderid = orderid;
		this.productid = productid;
		this.productname = productname;
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.creditcard = creditcard;
		this.orderquantity = orderquantity;
		this.state = state;
		this.city = city;
		this.street = street;
		this.mobile = mobile;
		this.zipcode = zipcode;
		this.createtime = createtime;
		this.totalamount = totalamount;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public Integer getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(Integer orderquantity) {
		this.orderquantity = orderquantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderid='" + orderid + '\'' +
				", productid='" + productid + '\'' +
				", userid='" + userid + '\'' +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", creditcard='" + creditcard + '\'' +
				", orderquantity=" + orderquantity +
				", state='" + state + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", mobile='" + mobile + '\'' +
				", zipcode='" + zipcode + '\'' +
				", createtime=" + createtime +
				", totalamount=" + totalamount +
				'}';
	}
}
