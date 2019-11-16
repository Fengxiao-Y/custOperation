package com.yidu.d280.focus.dao;

import java.util.List;

import com.yidu.d280.focus.domain.Cust;

public interface CustDao {
	/**
	 * ��ʵ���������ӵ����ݿ����
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ���������1�ɹ���0ʧ�ܣ�
	 */
	public int add(Cust cust);
	/**
	 * ���տͻ���ţ�������ɾ������
	 * @param cid �ͻ����
	 * @return Ӱ���������1�ɹ���0ʧ�ܣ�
	 */
	public int deleteById(String cid);
	/**
	 * ��ʵ���������µ����ݿ�
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ���������1�ɹ���0ʧ�ܣ�
	 */
	public int update(Cust cust);
	/**
	 * ���տͻ���ţ������������ݿ���в�������
	 * @param cid �ͻ����
	 * @return �ͻ�ʵ�����
	 */
	public Cust findById(String cid);
	
	//public List<Cust> findAll();
	/**
	 * ��ҳ����
	 * @param rows ����
	 * @param page ҳ��
	 * @return ָ��ҳ�е����ݼ���
	 */
	public List<Cust> findByPage(int rows,int page);
	/**
	 * ���ض�������ҳ����
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ��ѯ����
	 * @return ָ��ҳ�е����ݼ���
	 */
	public List<Cust> findByPage(int rows,int page,String condition);
	/**
	 * ͳ�������ݿ�������ݵ�������
	 * @return ����������
	 */
	public int count();
	/**
	 * ���ض�����ͳ�������ݿ���з�����������������
	 * @param condition ͳ������
	 * @return ���ط�����������������
	 */
	public int count(String condition);
}
