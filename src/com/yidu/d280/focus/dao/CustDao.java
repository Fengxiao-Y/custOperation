package com.yidu.d280.focus.dao;

import java.util.List;

import com.yidu.d280.focus.domain.Cust;

public interface CustDao {
	/**
	 * 将实体类对象添加到数据库表中
	 * @param cust 客户实体类对象
	 * @return 影响的行数（1成功，0失败）
	 */
	public int add(Cust cust);
	/**
	 * 按照客户编号（主键）删除数据
	 * @param cid 客户编号
	 * @return 影响的行数（1成功，0失败）
	 */
	public int deleteById(String cid);
	/**
	 * 将实体类对象更新到数据库
	 * @param cust 客户实体类对象
	 * @return 影响的行数（1成功，0失败）
	 */
	public int update(Cust cust);
	/**
	 * 按照客户编号（主键）从数据库表中查找数据
	 * @param cid 客户编号
	 * @return 客户实体对象
	 */
	public Cust findById(String cid);
	
	//public List<Cust> findAll();
	/**
	 * 分页查找
	 * @param rows 行数
	 * @param page 页数
	 * @return 指定页中的数据集合
	 */
	public List<Cust> findByPage(int rows,int page);
	/**
	 * 按特定条件分页查找
	 * @param rows 行数
	 * @param page 页数
	 * @param condition 查询条件
	 * @return 指定页中的数据集合
	 */
	public List<Cust> findByPage(int rows,int page,String condition);
	/**
	 * 统计数数据库表中数据的总行数
	 * @return 数据总行数
	 */
	public int count();
	/**
	 * 按特定条件统计数数据库表中符合条件的数据行数
	 * @param condition 统计条件
	 * @return 返回符合条件的数据行数
	 */
	public int count(String condition);
}
