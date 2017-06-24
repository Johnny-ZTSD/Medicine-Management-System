package com.entity;

public class Customer {
	private String accountNo; //�˻�����cstm_accountId_PK��
	private String password;    //�˿��˺����롾cstm_password��
	private int userType;    	//�û����͡�cstm_userType��
	private String realName;    //��ʵ������cstm_userType(char(1))��
	private String sex;		//�Ա�cstm_userType��
	private int accountState;   //�û��˺�״̬��cstm_accountState��Bool����
	private String telephone;   //�û��绰��cstm_telephone��;
	private int age;         	//���䡾cstm_age��
	private float consumpTotal; //�����ܶcstm_consumpTotal��
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
