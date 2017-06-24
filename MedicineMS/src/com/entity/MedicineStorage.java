package com.entity;

import java.sql.Date;

public class MedicineStorage {
	private int id;// msto_id_PK'【主键】药品库存编号'
	private String cmpn;// msto_cmpn_FK'【外键】国家药品准字号(Country Medicine Permit Number)',
	private String name;// msto_name '药品品名',
	private String batchNum;// msto_batchNum '生产批次号(数据引用：药品销售记录)',
	private String manufcName;// msto_manufcName '生产企业名',
	private double recomdPrice;// msto_recomdPrice '厂家推荐销售价格（单位：元）',
	private String productTele;// msto_productTele'厂商联系电话',
	private String productFax;// msto_productFax '厂家传真号码',
	private String productAddr;// msto_productAddr'生产地址',
	private String elecMonitCode;// msto_elecMonitCode '00000000000000000000' COMMENT '电子监管码(0值：无监管码)',
	private Date productDate;// msto_productDate '生产日期(数据来源：采购记录)',
	private Date expireDate;// msto_expireDate'有效日期(数据来源：采购记录)',
	private int sotorageNum;// msto_sotorageNum'库存数目（数据影响方：药品销售记录）',

	public MedicineStorage() {
		super();
	}

	public MedicineStorage(int id, String cmpn, String name, String batchNum, String manufcName, double recomdPrice,
			String productTele, String productFax, String productAddr, String elecMonitCode, Date productDate,
			Date expireDate, int sotorageNum) {
		super();
		this.id = id;
		this.cmpn = cmpn;
		this.name = name;
		this.batchNum = batchNum;
		this.manufcName = manufcName;
		this.recomdPrice = recomdPrice;
		this.productTele = productTele;
		this.productFax = productFax;
		this.productAddr = productAddr;
		this.elecMonitCode = elecMonitCode;
		this.productDate = productDate;
		this.expireDate = expireDate;
		this.sotorageNum = sotorageNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCmpn() {
		return cmpn;
	}

	public void setCmpn(String cmpn) {
		this.cmpn = cmpn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getManufcName() {
		return manufcName;
	}

	public void setManufcName(String manufcName) {
		this.manufcName = manufcName;
	}

	public double getRecomdPrice() {
		return recomdPrice;
	}

	public void setRecomdPrice(double recomdPrice) {
		this.recomdPrice = recomdPrice;
	}

	public String getProductTele() {
		return productTele;
	}

	public void setProductTele(String productTele) {
		this.productTele = productTele;
	}

	public String getProductFax() {
		return productFax;
	}

	public void setProductFax(String productFax) {
		this.productFax = productFax;
	}

	public String getProductAddr() {
		return productAddr;
	}

	public void setProductAddr(String productAddr) {
		this.productAddr = productAddr;
	}

	public String getElecMonitCode() {
		return elecMonitCode;
	}

	public void setElecMonitCode(String elecMonitCode) {
		this.elecMonitCode = elecMonitCode;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getSotorageNum() {
		return sotorageNum;
	}

	public void setSotorageNum(int sotorageNum) {
		this.sotorageNum = sotorageNum;
	}

	@Override
	public String toString() {
		return "MedicineStorage [id=" + id + ", cmpn=" + cmpn + ", name=" + name + ", batchNum=" + batchNum
				+ ", manufcName=" + manufcName + ", recomdPrice=" + recomdPrice + ", productTele=" + productTele
				+ ", productFax=" + productFax + ", productAddr=" + productAddr + ", elecMonitCode=" + elecMonitCode
				+ ", productDate=" + productDate + ", expireDate=" + expireDate + ", sotorageNum=" + sotorageNum + "]";
	}

}
