package com.entity;

import java.util.Date;

public class PurchaseProject {
	private String id;// ppro_id_PK '【主键】采购项目编号：时间(8)+顺序号(3)',
	private String name;// ppro_name '项目名称',
	private String descX;// ppro_descX '对项目的一个简单概述',
	private String sponsorId;// ppro_sponsorId_FK '【外键】发起者编号（通常:店长）',
	private Date startTime;// ppro_startTime '项目发起时间',
	private Date endTime;// ppro_endTime '2038-01-01 00:00:00' COMMENT '截止时间由
							// 店长自行设置(默认：最迟时间)',
	private int seek;// ppro_seek '采购项目下记录的种子值,手动增长',
	private int state;// ppro_state '项目状态：1：激活状态 0：关闭状态',

	public PurchaseProject() {
		super();
	}

	public PurchaseProject(String id, String name, String descX, String sponsorId, Date startTime, Date endTime,
			int seek, int state) {
		super();
		this.id = id;
		this.name = name;
		this.descX = descX;
		this.sponsorId = sponsorId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seek = seek;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdescX() {
		return descX;
	}

	public void setdescX(String descX) {
		this.descX = descX;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getSeek() {
		return seek;
	}

	public void setSeek(int seek) {
		this.seek = seek;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "PurchaseProject [id=" + id + ", name=" + name + ", descX=" + descX + ", sponsorId=" + sponsorId
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", seek=" + seek + ", state=" + state + "]";
	}

}
