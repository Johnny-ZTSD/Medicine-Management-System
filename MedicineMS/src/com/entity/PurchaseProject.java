package com.entity;

import java.util.Date;

public class PurchaseProject {
	private String id;// ppro_id_PK '���������ɹ���Ŀ��ţ�ʱ��(8)+˳���(3)',
	private String name;// ppro_name '��Ŀ����',
	private String descX;// ppro_descX '����Ŀ��һ���򵥸���',
	private String sponsorId;// ppro_sponsorId_FK '������������߱�ţ�ͨ��:�곤��',
	private Date startTime;// ppro_startTime '��Ŀ����ʱ��',
	private Date endTime;// ppro_endTime '2038-01-01 00:00:00' COMMENT '��ֹʱ����
							// �곤��������(Ĭ�ϣ����ʱ��)',
	private int seek;// ppro_seek '�ɹ���Ŀ�¼�¼������ֵ,�ֶ�����',
	private int state;// ppro_state '��Ŀ״̬��1������״̬ 0���ر�״̬',

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
