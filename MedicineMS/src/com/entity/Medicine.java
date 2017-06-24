package com.entity;

public class Medicine {
	
	private String cmpk; // ������������ҩƷ׼�ֺ�mdcn_cmpn_PK
	private String name; // ҩƷƷ��mdcn_name
	private boolean prescription; // �Ƿ񴦷�ҩmdcn_is
	private String component;// ҩƷ�ɷ� mdcn_component
	private String property;// ��״mdcn_property
	private String useType;// mdcn_useType 'ʹ�÷�ʽ:0 δ֪��1 ����ʳ�ã�2 �������ã�3 ����ʳ���ֿ�����'
	private String mainFun;// mdcn_mainFun '���ι���'
	private String standard;// mdcn_standard 'ҩƷ��񣺣�Eg:ÿƬ��x.xx�ˣ�'
	private String usageX;// mdcn_usageX '�÷�����(Eg:�ڷ�)'
	private String forbid;// mdcn_forbid '����'
	private String badEffect;// mdcn_badEffect '������Ӧ'
	private String attention;// mdcn_attention 'ע������'
	private String wrap;// mdcn_wrap '��װ'
	private String storageWay;// mdcn_storageWay '���淽ʽ'
	public Medicine() {
		super();
	}
	public Medicine(String cmpk, String name, boolean prescription, String component, String property, String useType,
			String mainFun, String standard, String usageX, String forbid, String badEffect, String attention,
			String wrap, String storageWay) {
		super();
		this.cmpk = cmpk;
		this.name = name;
		this.prescription = prescription;
		this.component = component;
		this.property = property;
		this.useType = useType;
		this.mainFun = mainFun;
		this.standard = standard;
		this.usageX = usageX;
		this.forbid = forbid;
		this.badEffect = badEffect;
		this.attention = attention;
		this.wrap = wrap;
		this.storageWay = storageWay;
	}
	public String getCmpk() {
		return cmpk;
	}
	public void setCmpk(String cmpk) {
		this.cmpk = cmpk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPrescription() {
		return prescription;
	}
	public void setPrescription(boolean prescription) {
		this.prescription = prescription;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public String getMainFun() {
		return mainFun;
	}
	public void setMainFun(String mainFun) {
		this.mainFun = mainFun;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getUsageX() {
		return usageX;
	}
	public void setUsageX(String usageX) {
		this.usageX = usageX;
	}
	public String getForbid() {
		return forbid;
	}
	public void setForbid(String forbid) {
		this.forbid = forbid;
	}
	public String getBadEffect() {
		return badEffect;
	}
	public void setBadEffect(String badEffect) {
		this.badEffect = badEffect;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getWrap() {
		return wrap;
	}
	public void setWrap(String wrap) {
		this.wrap = wrap;
	}
	public String getStorageWay() {
		return storageWay;
	}
	public void setStorageWay(String storageWay) {
		this.storageWay = storageWay;
	}
	@Override
	public String toString() {
		return "Medicine [cmpk=" + cmpk + ", \nname=" + name + ", \nprescription=" + prescription + ", \ncomponent="
				+ component + ", \nproperty=" + property + ", \nuseType=" + useType + ", \nmainFun=" + mainFun
				+ ", \nstandard=" + standard + ", \nusageX=" + usageX + ", \nforbid=" + forbid + ", \nbadEffect="
				+ badEffect + ", \nattention=" + attention + ", \nwrap=" + wrap + ", \nstorageWay=" + storageWay + "]";
	}
	
}
