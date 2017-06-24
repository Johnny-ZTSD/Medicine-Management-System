package com.entity.ViewObject;

import java.util.Date;

public class MSaleRecord_FeedBack {
	private String id;// msrd_id_PK '��������ҩƷ���ۼ�¼���-32λ',��������UUID��д��
	private String medicineName;// msrd_name 'ҩƷƷ��(������Դ��ҩƷ���� ���� ӪҵԱ����)',���û���д��
	private double salePrice;// msrd_salePrice '���ۼ۸񣨿����볧���Ƽ��۸�һ����Ĭ�ϣ��Ƽ��۸�',���û���д��
	private int saleNum;// msrd_saleNum '������Ŀ',���û���д��
	private double amountPayable; //Ӧ�����
	private double payAmountMoney; //�˿�֧�����
	private double oddChange; //����
	private String customerAccountNo;//�˿��˻�
	private String salerName; //����������
	
	//��������
	private String cmpn;// msrd_cmpn_FK '���������ҩ׼�ֺ�',���û���д��
	private String batchNum;// msrd_batchNum '�������κ�(������Դ��ҩƷ����-ҩƷ�������κ�)',���û���д��
	private Date saleDate;// msrd_saleDate '����ʱ��',����������д��
	
//	private String customerAccountNo;
	private String salerId;// msrd_salerId_FK'�����������Ա�˺ţ�8�����������˲���',����������д��

	public MSaleRecord_FeedBack() {
		super();
	}

	public MSaleRecord_FeedBack(String id, String medicineName, double salePrice, int saleNum, double amountPayable,
			double payAmountMoney, double oddChange, String customerAccountNo, String salerName, String cmpn,
			String batchNum, Date saleDate, String salerId) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.salePrice = salePrice;
		this.saleNum = saleNum;
		this.amountPayable = amountPayable;
		this.payAmountMoney = payAmountMoney;
		this.oddChange = oddChange;
		this.customerAccountNo = customerAccountNo;
		this.salerName = salerName;
		this.cmpn = cmpn;
		this.batchNum = batchNum;
		this.saleDate = saleDate;
		this.salerId = salerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public double getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}

	public double getPayAmountMoney() {
		return payAmountMoney;
	}

	public void setPayAmountMoney(double payAmountMoney) {
		this.payAmountMoney = payAmountMoney;
	}

	public double getOddChange() {
		return oddChange;
	}

	public void setOddChange(double oddChange) {
		this.oddChange = ((int)(oddChange*100))/100;
	}

	public String getCustomerAccountNo() {
		return customerAccountNo;
	}

	public void setCustomerAccountNo(String customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
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

	public String getSalerId() {
		return salerId;
	}

	public void setSalerId(String salerId) {
		this.salerId = salerId;
	}

	@Override
	public String toString() {
		return "MSalaRecord_FeedBack [id=" + id + ", medicineName=" + medicineName + ", salePrice=" + salePrice + ", saleNum=" + saleNum
				+ ", amountPayable=" + amountPayable + ", payAmountMoney=" + payAmountMoney + ", oddChange=" + oddChange
				+ ", customerAccountNo=" + customerAccountNo + ", salerName=" + salerName + ", cmpn=" + cmpn
				+ ", batchNum=" + batchNum + ", saleDate=" + saleDate + ", salerId=" + salerId + "]";
	}
	
	
	
}
