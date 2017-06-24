package com.entity;

public class Medicine {
	
	private String cmpk; // 【主键】国家药品准字号mdcn_cmpn_PK
	private String name; // 药品品名mdcn_name
	private boolean prescription; // 是否处方药mdcn_is
	private String component;// 药品成分 mdcn_component
	private String property;// 性状mdcn_property
	private String useType;// mdcn_useType '使用方式:0 未知；1 仅可食用；2 仅可外用；3 即可食用又可外用'
	private String mainFun;// mdcn_mainFun '主治功能'
	private String standard;// mdcn_standard '药品规格：（Eg:每片重x.xx克）'
	private String usageX;// mdcn_usageX '用法用量(Eg:口服)'
	private String forbid;// mdcn_forbid '禁忌'
	private String badEffect;// mdcn_badEffect '不良反应'
	private String attention;// mdcn_attention '注意事项'
	private String wrap;// mdcn_wrap '包装'
	private String storageWay;// mdcn_storageWay '贮存方式'
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
