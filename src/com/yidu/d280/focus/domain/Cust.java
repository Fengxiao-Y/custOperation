package com.yidu.d280.focus.domain;

import java.io.Serializable;

public class Cust implements Serializable{
	//全球统一序列号
	private static final long serialVersionUID = 6853240540886728043L;
	//客户编号
	private String cid; 
	//客户姓名
	private String cname; 
	//客户性别
	private String sex; 
	//电话
	private String telphone;
	//办卡日期
	private String cardDate; 
	//账户余额
	private double rateMoney; 
	//经手人编号
	private String eno;
	/**
	 * 默认构造方法
	 */
	public Cust() {
		super();
	}
	/**
	 * 带参数构造方法
	 * @param cid 客户编号
	 * @param cname 客户姓名
	 * @param sex 性别
	 * @param telphone 电话
 	 * @param cardDate 办卡日期
	 * @param rateMoney 卡上余额
	 * @param eno 经手人编号
	 */
	public Cust(String cid, String cname, String sex, String telphone, String cardDate, double rateMoney, String eno) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.sex = sex;
		this.telphone = telphone;
		this.cardDate = cardDate;
		this.rateMoney = rateMoney;
		this.eno = eno;
	}
	//自动生成的setter/getter方法	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getCardDate() {
		return cardDate;
	}

	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}

	public double getRateMoney() {
		return rateMoney;
	}

	public void setRateMoney(double rateMoney) {
		this.rateMoney = rateMoney;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}
	
}
