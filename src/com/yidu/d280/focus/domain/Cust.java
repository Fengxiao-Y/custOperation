package com.yidu.d280.focus.domain;

import java.io.Serializable;

public class Cust implements Serializable{
	//ȫ��ͳһ���к�
	private static final long serialVersionUID = 6853240540886728043L;
	//�ͻ����
	private String cid; 
	//�ͻ�����
	private String cname; 
	//�ͻ��Ա�
	private String sex; 
	//�绰
	private String telphone;
	//�쿨����
	private String cardDate; 
	//�˻����
	private double rateMoney; 
	//�����˱��
	private String eno;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Cust() {
		super();
	}
	/**
	 * ���������췽��
	 * @param cid �ͻ����
	 * @param cname �ͻ�����
	 * @param sex �Ա�
	 * @param telphone �绰
 	 * @param cardDate �쿨����
	 * @param rateMoney �������
	 * @param eno �����˱��
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
	//�Զ����ɵ�setter/getter����	
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
