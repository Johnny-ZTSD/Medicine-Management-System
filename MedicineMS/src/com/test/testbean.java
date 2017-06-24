package com.test;

public class testbean {
	public String bean_id = "ID435893468966";
	public String bean_password = "0123456";
	public String bean_name = "ÄäÃûÓÃ»§";
	public String bean_sex = "M";
	public testbean() {
		super();
	}
	public testbean(String bean_id, String bean_password, String bean_name, String bean_sex) {
		super();
		this.bean_id = bean_id;
		this.bean_password = bean_password;
		this.bean_name = bean_name;
		this.bean_sex = bean_sex;
	}
	public String getBean_id() {
		return bean_id;
	}
	public void setBean_id(String bean_id) {
		this.bean_id = bean_id;
	}
	public String getBean_password() {
		return bean_password;
	}
	public void setBean_password(String bean_password) {
		this.bean_password = bean_password;
	}
	public String getBean_name() {
		return bean_name;
	}
	public void setBean_name(String bean_name) {
		this.bean_name = bean_name;
	}
	public String getBean_sex() {
		return bean_sex;
	}
	public void setBean_sex(String bean_sex) {
		this.bean_sex = bean_sex;
	}
	@Override
	public String toString() {
		return "testbean [bean_id=" + bean_id + ", bean_password=" + bean_password + ", bean_name=" + bean_name
				+ ", bean_sex=" + bean_sex + "]";
	}

}