package com.entity;

import java.util.Date;

public class MSaleRecord {
	private String id;// msrd_id_PK '��������ҩƷ���ۼ�¼���-32λ',��������UUID��д��
	private String cmpn;// msrd_cmpn_FK '���������ҩ׼�ֺ�',���û���д��
	private String batchNum;// msrd_batchNum '�������κ�(������Դ��ҩƷ����-ҩƷ�������κ�)',���û���д��
	private Date saleDate;// msrd_saleDate '����ʱ��',����������д��
	private String name;// msrd_name 'ҩƷƷ��(������Դ��ҩƷ���� ���� ӪҵԱ����)',���û���д��
	private int saleNum;// msrd_saleNum '������Ŀ',���û���д��
	private double salePrice;// msrd_salePrice '���ۼ۸񣨿����볧���Ƽ��۸�һ����Ĭ�ϣ��Ƽ��۸�',���û���д��
	private String customerId;// msrd_customerId;//msrd_customerId_FK���û���д��
								// '��������˿��˺ţ�8�����Զ�����(0000000000 ��Ϊ�����˿�)',
	private String salerId;// msrd_salerId_FK'�����������Ա�˺ţ�8�����������˲���',����������д��

	public MSaleRecord() {
		super();
	}

	public MSaleRecord(String id, String cmpn, String batchNum, Date saleDate, String name, int saleNum, double salePrice,
			String customerId, String salerId) {
		super();
		this.id = id;
		this.cmpn = cmpn;
		this.batchNum = batchNum;
		this.saleDate = saleDate;
		this.name = name;
		this.saleNum = saleNum;
		this.salePrice = salePrice;
		this.customerId = customerId;
		this.salerId = salerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmpn() {
		return cmpn;
	}

	public void setCmpn(String cmpn) {
		this.cmpn = cmpn;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSalerId() {
		return salerId;
	}

	public void setSalerId(String salerId) {
		this.salerId = salerId;
	}

	@Override
	public String toString() {
		return "MSaleRecord [id=" + id + ", cmpn=" + cmpn + ", batchNum=" + batchNum + ", saleDate=" + saleDate
				+ ", name=" + name + ", saleNum=" + saleNum + ", salePrice=" + salePrice + ", customerId=" + customerId
				+ ", salerId=" + salerId + "]";
	}

}
