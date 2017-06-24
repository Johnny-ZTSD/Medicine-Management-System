package com.entity;

import java.util.Date;

public class PurchaseRecord {
	private int id;// prcd_id_PK '���������ɹ���¼��ţ��Զ�����',
	private String purchaserId;// prcd_purchaserId_FK
								// '��������ɹ��߱�ţ��˺ţ�8������ְ���ڣ�6���꣨4��+�£�2����+Ա��˳��ţ�2��',
	private Date finishTime;// prcd_finishTime '�ɹ���(��¼)�����ʱ��',
	private String isFinish;// prcd_isFinish '�ɹ���¼���״̬ 1:�Ѿ���� 0��false���������',
	private String cmpn;// prcd_cmpn_FK '���������ҩ׼�ֺţ�����������9-10λ����',
	private String productNum;// prcd_productNum '�������κ�',
	private String medicineName;// prcd_medicineName 'ҩƷƷ�� ',
	private String type;// prcd_type 'ҩƷ�ͺ�',
	private String price;// prcd_price '�ɹ��۸�',
	private Date productDate;// prcd_productDate
								// '��������(8):(YYYY-MM-DD)���������ã�ҩƷ��棩',
	private Date expireDate;// prcd_expireDate '��Ч��ֹ���ڣ��������ã�ҩƷ��棩',
	private int medicineNum;// prcd_medicineNum 'ҩƷ��Ŀ',

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
