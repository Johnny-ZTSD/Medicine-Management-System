package com.entity;

import java.sql.Date;

public class MedicineStorage {
	private int id;// msto_id_PK'��������ҩƷ�����'
	private String cmpn;// msto_cmpn_FK'�����������ҩƷ׼�ֺ�(Country Medicine Permit Number)',
	private String name;// msto_name 'ҩƷƷ��',
	private String batchNum;// msto_batchNum '�������κ�(�������ã�ҩƷ���ۼ�¼)',
	private String manufcName;// msto_manufcName '������ҵ��',
	private double recomdPrice;// msto_recomdPrice '�����Ƽ����ۼ۸񣨵�λ��Ԫ��',
	private String productTele;// msto_productTele'������ϵ�绰',
	private String productFax;// msto_productFax '���Ҵ������',
	private String productAddr;// msto_productAddr'������ַ',
	private String elecMonitCode;// msto_elecMonitCode '00000000000000000000' COMMENT '���Ӽ����(0ֵ���޼����)',
	private Date productDate;// msto_productDate '��������(������Դ���ɹ���¼)',
	private Date expireDate;// msto_expireDate'��Ч����(������Դ���ɹ���¼)',
	private int sotorageNum;// msto_sotorageNum'�����Ŀ������Ӱ�췽��ҩƷ���ۼ�¼��',

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
