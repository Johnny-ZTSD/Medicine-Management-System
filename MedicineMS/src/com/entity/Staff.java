package com.entity;

import java.lang.reflect.Field;

public class Staff{
	
	private String accountNo; //�˺�����staf_accountId_PK��
	private String password; //���롾staf_password��
	private int userType;//�û����͡�staf_userType��1 ����Ա(����);2 ӪҵԱ;3 ����Ա����ʱ���ã�;4 �ɹ�Ա
	private String realName;  //��ʵ������staf_realName��;
	private String sex; //�û��Ա�staf_sex��'M','F' (char(1))��
	private int accountState; //�û��˺�״̬��1(true) ����; 0 ����(��Ϊע������ְ������ �˻�������)��
	private String telephone; //�û��绰��staf_telephone��;
	
	public Staff() {
		super();
	}
	
	public Staff(String accountNo, String password, int userType, String realName, String sex, int accountState,
			String telephone) {
		super();
		this.accountNo = accountNo;
		this.password = password;
		this.userType = userType;
		this.realName = realName;
		this.sex = sex;
		this.accountState = accountState;
		this.telephone = telephone;
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
	
	@Override
	public String toString() {
		return "Staff [accountNo=" + accountNo + ", password=" + password + ", userType=" + userType + ", realName="
				+ realName + ", sex=" + sex + ", accountState=" + accountState + ", telephone=" + telephone + "]";
	}
//	
//	/*
//	 * ��ȡstaffʵ���ڵ�ֵ
//	 * */
//	public static String[] getValues(Staff staff){
//		
//		Field fields[] = Staff.class.getDeclaredFields();
//		String values[] = new String[fields.length]; 
//		for(int i=0;i<fields.length;i++){
//				try {
//					values[i] = fields[i].get(staff).toString();
//					System.out.println(values[i]);
//				} catch (IllegalArgumentException e) {
//					System.out.println("******************getValues()�쳣******************");
//					e.printStackTrace();
//					return null;
//				} catch (IllegalAccessException e) {
//					System.out.println("******************getValues()�쳣******************");
//					e.printStackTrace();
//					return null;
//				}
//			
//		}
//		return values;
//	}
	
//	public static void main(String args[]) {
//		Staff staff = new Staff("admin123","123456",1,"��̫",'M',1,"15202843104");
//		Staff.getValues(staff);
//	}
}