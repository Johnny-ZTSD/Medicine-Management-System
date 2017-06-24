package com.entity;

import java.util.Date;

public class MSaleRecord {
	private String id;// msrd_id_PK '【主键】药品销售记录编号-32位',【服务器UUID填写】
	private String cmpn;// msrd_cmpn_FK '【外键】国药准字号',【用户填写】
	private String batchNum;// msrd_batchNum '生产批次号(数据来源：药品库存表-药品生产批次号)',【用户填写】
	private Date saleDate;// msrd_saleDate '销售时间',【服务器填写】
	private String name;// msrd_name '药品品名(数据来源：药品库存表 或者 营业员自填)',【用户填写】
	private int saleNum;// msrd_saleNum '销售数目',【用户填写】
	private double salePrice;// msrd_salePrice '销售价格（可能与厂商推荐价格不一样，默认：推荐价格）',【用户填写】
	private String customerId;// msrd_customerId;//msrd_customerId_FK【用户填写】
								// '【外键】顾客账号（8）：自动增长(0000000000 视为匿名顾客)',
	private String salerId;// msrd_salerId_FK'【外键】销售员账号（8）：服务器端插入',【服务器填写】

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
