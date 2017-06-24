package com.entity;

public class Customer {
	private String accountNo; //账户名【cstm_accountId_PK】
	private String password;    //顾客账号密码【cstm_password】
	private int userType;    	//用户类型【cstm_userType】
	private String realName;    //真实姓名【cstm_userType(char(1))】
	private String sex;		//性别【cstm_userType】
	private int accountState;   //用户账号状态【cstm_accountState（Bool）】
	private String telephone;   //用户电话【cstm_telephone】;
	private int age;         	//年龄【cstm_age】
	private float consumpTotal; //消费总额【cstm_consumpTotal】
	public Customer() {
		super();
	}
	public Customer(String accountNo, String password, int userType, String realName, String sex, int accountState,
			String telephone, int age, float consumpTotal) {
		super();
		this.accountNo = accountNo;
		this.password = password;
		this.userType = userType;
		this.realName = realName;
		this.sex = sex;
		this.accountState = accountState;
		this.telephone = telephone;
		this.age = age;
		this.consumpTotal = consumpTotal;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAccountState() {
		return accountState;
	}
	public void setAccountState(int accountState) {
		this.accountState = accountState;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getConsumpTotal() {
		return consumpTotal;
	}
	public void setConsumpTotal(float consumpTotal) {
		this.consumpTotal = consumpTotal;
	}
	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", password=" + password + ", userType=" + userType + ", realName="
				+ realName + ", sex=" + sex + ", accountState=" + accountState + ", telephone=" + telephone + ", age="
				+ age + ", consumpTotal=" + consumpTotal + "]";
	}
	
	
}
