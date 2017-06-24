package com.entity;

public class Register {
	private String id;	 //rgst_id_PK 		varchar(32)  not null primary KEY 		COMMENT '��������ע���˻��������ߵı��[ʹ��UUID����]', 
	private String email;//rgst_email 		varchar(254) not null unique 			COMMENT 'ע��������������ַ',
	private String realName;//rgst_realName 	VARCHAR(50)  NOT NULL 					COMMENT '����������',
	private String phone;//rgst_telephone  varchar(13)  NOT NULL                   COMMENT '�����ߵ绰',
	private String state;//rgst_state      char(3)		 not null default '000'     COMMENT '�����˺�״̬[000:�����룬δ���� | 001���Ѿ�����(��������)]',
	private String accountId;//rgst_accountId  varchar(30)	 							COMMENT '�����������ɹ�����˻���[��Ϊ��¼����]',
	public Register() {
		super();
	}
	
	
	//�����˺�ʱ��Ĭ������
	public Register(String id, String email, String realName, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.realName = realName;
		this.phone = phone;
		this.state = "000"; //δ����
		this.accountId = "/";//û���˺�
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
