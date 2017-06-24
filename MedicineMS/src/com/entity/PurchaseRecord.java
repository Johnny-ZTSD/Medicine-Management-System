package com.entity;

import java.util.Date;

public class PurchaseRecord {
	private int id;// prcd_id_PK '【主键】采购记录编号：自动增长',
	private String purchaserId;// prcd_purchaserId_FK
								// '【外键】采购者编号：账号（8）：入职日期（6，年（4）+月（2））+员工顺序号（2）',
	private Date finishTime;// prcd_finishTime '采购项(记录)的完成时间',
	private String isFinish;// prcd_isFinish '采购记录完成状态 1:已经完成 0（false）：待完成',
	private String cmpn;// prcd_cmpn_FK '【外键】国药准字号（长度限制在9-10位数）',
	private String productNum;// prcd_productNum '生产批次号',
	private String medicineName;// prcd_medicineName '药品品名 ',
	private String type;// prcd_type '药品型号',
	private String price;// prcd_price '采购价格',
	private Date productDate;// prcd_productDate
								// '生产日期(8):(YYYY-MM-DD)（数据引用：药品库存）',
	private Date expireDate;// prcd_expireDate '有效截止日期（数据引用：药品库存）',
	private int medicineNum;// prcd_medicineNum '药品数目',

	public PurchaseRecord() {
		super();
	}

	public PurchaseRecord(int id, String purchaserId, Date finishTime, String isFinish, String cmpn, String productNum,
			String medicineName, String type, String price, Date productDate, Date expireDate, int medicineNum) {
		super();
		this.id = id;
		this.purchaserId = purchaserId;
		this.finishTime = finishTime;
		this.isFinish = isFinish;
		this.cmpn = cmpn;
		this.productNum = productNum;
		this.medicineName = medicineName;
		this.type = type;
		this.price = price;
		this.productDate = productDate;
		this.expireDate = expireDate;
		this.medicineNum = medicineNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}

	public String getCmpn() {
		return cmpn;
	}

	public void setCmpn(String cmpn) {
		this.cmpn = cmpn;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public int getMedicineNum() {
		return medicineNum;
	}

	public void setMedicineNum(int medicineNum) {
		this.medicineNum = medicineNum;
	}

	@Override
	public String toString() {
		return "PurchaseRecord [id=" + id + ", purchaserId=" + purchaserId + ", finishTime=" + finishTime
				+ ", isFinish=" + isFinish + ", cmpn=" + cmpn + ", productNum=" + productNum + ", medicineName="
				+ medicineName + ", type=" + type + ", price=" + price + ", productDate=" + productDate
				+ ", expireDate=" + expireDate + ", medicineNum=" + medicineNum + "]";
	}

}
