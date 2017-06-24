package com.entity.ViewObject;

import java.util.Date;

public class MSaleRecord_FeedBack {
	private String id;// msrd_id_PK '【主键】药品销售记录编号-32位',【服务器UUID填写】
	private String medicineName;// msrd_name '药品品名(数据来源：药品库存表 或者 营业员自填)',【用户填写】
	private double salePrice;// msrd_salePrice '销售价格（可能与厂商推荐价格不一样，默认：推荐价格）',【用户填写】
	private int saleNum;// msrd_saleNum '销售数目',【用户填写】
	private double amountPayable; //应付金额
	private double payAmountMoney; //顾客支付金额
	private double oddChange; //找零
	private String customerAccountNo;//顾客账户
	private String salerName; //销售者姓名
	
	//其他属性
	private String cmpn;// msrd_cmpn_FK '【外键】国药准字号',【用户填写】
	private String batchNum;// msrd_batchNum '生产批次号(数据来源：药品库存表-药品生产批次号)',【用户填写】
	private Date saleDate;// msrd_saleDate '销售时间',【服务器填写】
	
//	private String customerAccountNo;
	private String salerId;// msrd_salerId_FK'【外键】销售员账号（8）：服务器端插入',【服务器填写】

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
