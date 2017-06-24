package com.entity;

import java.util.Date;

public class FeedBack {
	private String id;// fdbc_id_PK char(32) not null primary KEY COMMENT
						// '【主键】用户反馈记录的编号[使用UUID创建]',
	private String email = "/";// fdbc_email varchar(254) COMMENT '用户的邮箱地址',
	private String realName = "/";// fdbc_realName VARCHAR(50) COMMENT '用户姓名',
	private String phone = "/";// fdbc_telephone varchar(13) COMMENT '用户电话',
	private String message = "/";// fdbc_message varchar(255) COMMENT '用户反馈的消息',
	private String readState = "/";// fdbc_readState char(3) default '000'
									// COMMENT '反馈记录阅读状态：000未读 001：已读',
	private Date sendDate = new Date();// fdbc_sendDate datetime not null
										// DEFAULT now()
	// COMMENT '反馈消息创建时间'

	public FeedBack() {
		super();
	}

	public FeedBack(String id, String email, String realName, String phone, String message, String readState) {
		super();
		this.id = id;
		this.email = email;
		this.realName = realName;
		this.phone = phone;
		this.message = message;
		this.readState = readState;
	}

	public FeedBack(String id, String email, String realName, String phone, String message, String readState,
			Date sendDate) {
		super();
		this.id = id;
		this.email = email;
		this.realName = realName;
		this.phone = phone;
		this.message = message;
		this.readState = readState;
		this.sendDate = sendDate;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReadState() {
		return readState;
	}

	public void setReadState(String readState) {
		this.readState = readState;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", email=" + email + ", realName=" + realName + ", phone=" + phone + ", message="
				+ message + ", readState=" + readState + "]";
	}

}
