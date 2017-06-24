package com.entity;

public class Register {
	private String id;	 //rgst_id_PK 		varchar(32)  not null primary KEY 		COMMENT '【主键】注册账户的申请者的编号[使用UUID创建]', 
	private String email;//rgst_email 		varchar(254) not null unique 			COMMENT '注册者申请的邮箱地址',
	private String realName;//rgst_realName 	VARCHAR(50)  NOT NULL 					COMMENT '申请者姓名',
	private String phone;//rgst_telephone  varchar(13)  NOT NULL                   COMMENT '申请者电话',
	private String state;//rgst_state      char(3)		 not null default '000'     COMMENT '申请账号状态[000:仅申请，未处理 | 001：已经处理(发送邮箱)]',
	private String accountId;//rgst_accountId  varchar(30)	 							COMMENT '【外键】申请成功后的账户名[作为记录留存]',
	public Register() {
		super();
	}
	
	
	//申请账号时：默认设置
	public Register(String id, String email, String realName, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.realName = realName;
		this.phone = phone;
		this.state = "000"; //未处理
		this.accountId = "/";//没有账号
	}



	public Register(String id, String email, String realName, String phone, String state, String accountId) {
		super();
		this.id = id;
		this.email = email;
		this.realName = realName;
		this.phone = phone;
		this.state = state;
		this.accountId = accountId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", email=" + email + ", realName=" + realName + ", phone=" + phone + ", state="
				+ state + ", accountId=" + accountId + "]";
	}
	
	
	
}	
