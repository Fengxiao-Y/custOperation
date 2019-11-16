package com.yidu.d280.dao.focus.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.d280.focus.dao.CustDao;
import com.yidu.d280.focus.domain.Cust;
import com.yidu.d280.focus.domain.Emp;
import com.yidu.d280.focus.utils.JdbcUtils;

public class CustDaoImpl implements CustDao {
	/**
	 * 将实体类对象添加到数据库表中
	 * @param cust 客户实体类对象
	 * @return 影响的行数（1成功，0失败）
	 */
	@Override
	public int add(Cust cust) {
		//定义影响行数变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句字符串
			String sql="INSERT INTO cust(cid,cname,sex,telphone,cardDate,rateMoney,eno) VALUES(?,?,?,?,?,?,?)";
			//使用sql语句及数据库连接对象实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql字符串中参数赋值
			pstmt.setString(1, cust.getCid());
			pstmt.setString(2, cust.getCname());
			pstmt.setString(3, cust.getSex());
			pstmt.setString(4, cust.getTelphone());
			//将字符串转换成数据库日期数据
			pstmt.setDate(5, java.sql.Date.valueOf(cust.getCardDate()));
			//pstmt.setString(5, cust.getCardDate());
			pstmt.setDouble(6, cust.getRateMoney());
			pstmt.setString(7, cust.getEno());
			//执行预编译语句对象，得到影响行数
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响行数
		return rows;
	}
	/**
	 * 按照客户编号（主键）删除数据
	 * @param cid 客户编号
	 * @return 影响的行数（1成功，0失败）
	 */
	@Override
	public int deleteById(String cid) {
		//定义影响行数变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句字符串
			String sql="delete from cust where cid=?";
			//使用sql语句及数据库连接对象实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql字符串中参数赋值
			pstmt.setString(1, cid);
			//执行预编译语句对象，得到影响行数
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响行数
		return rows;
	}
	/**
	 * 将实体类对象更新到数据库
	 * @param cust 客户实体类对象
	 * @return 影响的行数（1成功，0失败）
	 */
	@Override
	public int update(Cust cust) {
		//定义影响行数变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句字符串
			String sql="update cust set cname=?,sex=?,telphone=?,cardDate=?,rateMoney=?,eno=? where cid=?";
			//使用sql语句及数据库连接对象实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql字符串中参数赋值			
			pstmt.setString(1, cust.getCname());
			pstmt.setString(2, cust.getSex());
			pstmt.setString(3, cust.getTelphone());
			//将字符串转换成数据库日期数据
			pstmt.setDate(4, java.sql.Date.valueOf(cust.getCardDate()));
			//pstmt.setString(4, cust.getCardDate());
			pstmt.setDouble(5, cust.getRateMoney());
			pstmt.setString(6, cust.getEno());
			pstmt.setString(7, cust.getCid());
			//执行预编译语句对象，得到影响行数
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回影响行数
		return rows;
	}
	/**
	 * 按照客户编号（主键）从数据库表中查找数据
	 * @param cid 客户编号
	 * @return 客户实体对象
	 */
	@Override
	public Cust findById(String cid) {
		//声明客户对象
		Cust cust=null;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql字符串
			String sql="select cid,cname,sex,telphone,cardDate,rateMoney,eno from cust where cid=?";
			//使用数据库连接对象及sql字符串实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql字符串中参数赋值
			pstmt.setString(1, cid);
			//执行预编译语句对象，得到结果集
			rs=pstmt.executeQuery();
			if(rs.next()){
				//实例化客户对象
				cust=new Cust();
				//将结果集中数据保存到客户对象中
				cust.setCid(rs.getString("cid"));
				cust.setCname(rs.getString("cname"));
				cust.setSex(rs.getString("sex"));
				//日期格式转换
				cust.setTelphone(rs.getString("telphone"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				cust.setCardDate(sdf.format(rs.getDate("cardDate")));
				cust.setRateMoney(rs.getDouble("rateMoney"));
				cust.setEno(rs.getString("eno"));
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回对象
		return cust;
	}
	/**
	 * 分页查找
	 * @param rows 行数
	 * @param page 页数
	 * @return 指定页中的数据集合
	 */
	@Override
	public List<Cust> findByPage(int rows, int page) {
		//定义客户对象集合
		List<Cust> custList=new ArrayList<Cust>();
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果接对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="select * from cust limit ?,?";
			//使用数据库连接对象及sql字符串实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql字符串中参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//执行预编译语句对象，得到结果集
			rs=pstmt.executeQuery();
			//使用循环处理结果集
			while(rs.next()){
				//定义客户对象
				Cust cust=new Cust();
				//将结果集的数据保存到客户对象中
				cust.setCid(rs.getString("cid"));
				cust.setCname(rs.getString("cname"));
				cust.setSex(rs.getString("sex"));
				cust.setTelphone(rs.getString("telphone"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				cust.setCardDate(sdf.format(rs.getDate("cardDate")));
				cust.setRateMoney(rs.getDouble("rateMoney"));
				cust.setEno(rs.getString("eno"));
				//将客户对象添加到客户集合中
				custList.add(cust);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回客户集合
		return custList;
	}
	/**
	 * 按特定条件分页查找
	 * @param rows 行数
	 * @param page 页数
	 * @param condition 查询条件
	 * @return 指定页中的数据集合
	 */
	@Override
	public List<Cust> findByPage(int rows, int page, String condition) {
		//定义客户集合对象
		List<Cust> custList=new ArrayList<Cust>();
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql字符串
			String sql="select * from cust "+condition+" limit ?,?";
			//使用数据库连接对象及sql字符串实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql字符串中的参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//执行预编译语句对象，得到结果集
			rs=pstmt.executeQuery();
			//使用循环处理结果集
			while(rs.next()){
				//定义客户对象
				Cust cust=new Cust();
				//将结果集中的数据保存到客户对象中
				cust.setCid(rs.getString("cid"));
				cust.setCname(rs.getString("cname"));
				cust.setSex(rs.getString("sex"));
				cust.setTelphone(rs.getString("telphone"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				cust.setCardDate(sdf.format(rs.getDate("cardDate")));
				cust.setRateMoney(rs.getDouble("rateMoney"));
				cust.setEno(rs.getString("eno"));
				//将对象添加到客户集合中
				custList.add(cust);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回客户集合
		return custList;
	}
	/**
	 * 统计数数据库表中数据的总行数
	 * @return 数据总行数
	 */
	@Override
	public int count() {
		//定义影响行数变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql字符串
			String sql="select count(*) from cust";
			//使用数据库连接对象及sql字符串实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//执行预编译语句对象，得到结果集
			rs=pstmt.executeQuery();
			//判断结果集
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回行数
		return rows;
	}
	/**
	 * 按特定条件统计数数据库表中符合条件的数据行数
	 * @param condition 统计条件
	 * @return 返回符合条件的数据行数
	 */
	@Override
	public int count(String condition) {
		//定义影响行数变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明预编译语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="select count(*) from cust "+condition;
			//使用数据库连接对象及 sql字符串实例化预编译语句对象
			pstmt=conn.prepareStatement(sql);
			//执行预编译语句对象得到结果集
			rs=pstmt.executeQuery();
			//判断结果集
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回行数
		return rows;
	}

}
