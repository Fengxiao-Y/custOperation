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
	 * ��ʵ���������ӵ����ݿ����
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ���������1�ɹ���0ʧ�ܣ�
	 */
	@Override
	public int add(Cust cust) {
		//����Ӱ����������
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql����ַ���
			String sql="INSERT INTO cust(cid,cname,sex,telphone,cardDate,rateMoney,eno) VALUES(?,?,?,?,?,?,?)";
			//ʹ��sql��估���ݿ����Ӷ���ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��sql�ַ����в�����ֵ
			pstmt.setString(1, cust.getCid());
			pstmt.setString(2, cust.getCname());
			pstmt.setString(3, cust.getSex());
			pstmt.setString(4, cust.getTelphone());
			//���ַ���ת�������ݿ���������
			pstmt.setDate(5, java.sql.Date.valueOf(cust.getCardDate()));
			//pstmt.setString(5, cust.getCardDate());
			pstmt.setDouble(6, cust.getRateMoney());
			pstmt.setString(7, cust.getEno());
			//ִ��Ԥ���������󣬵õ�Ӱ������
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ������
		return rows;
	}
	/**
	 * ���տͻ���ţ�������ɾ������
	 * @param cid �ͻ����
	 * @return Ӱ���������1�ɹ���0ʧ�ܣ�
	 */
	@Override
	public int deleteById(String cid) {
		//����Ӱ����������
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql����ַ���
			String sql="delete from cust where cid=?";
			//ʹ��sql��估���ݿ����Ӷ���ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��sql�ַ����в�����ֵ
			pstmt.setString(1, cid);
			//ִ��Ԥ���������󣬵õ�Ӱ������
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ������
		return rows;
	}
	/**
	 * ��ʵ���������µ����ݿ�
	 * @param cust �ͻ�ʵ�������
	 * @return Ӱ���������1�ɹ���0ʧ�ܣ�
	 */
	@Override
	public int update(Cust cust) {
		//����Ӱ����������
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql����ַ���
			String sql="update cust set cname=?,sex=?,telphone=?,cardDate=?,rateMoney=?,eno=? where cid=?";
			//ʹ��sql��估���ݿ����Ӷ���ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��sql�ַ����в�����ֵ			
			pstmt.setString(1, cust.getCname());
			pstmt.setString(2, cust.getSex());
			pstmt.setString(3, cust.getTelphone());
			//���ַ���ת�������ݿ���������
			pstmt.setDate(4, java.sql.Date.valueOf(cust.getCardDate()));
			//pstmt.setString(4, cust.getCardDate());
			pstmt.setDouble(5, cust.getRateMoney());
			pstmt.setString(6, cust.getEno());
			pstmt.setString(7, cust.getCid());
			//ִ��Ԥ���������󣬵õ�Ӱ������
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(null, pstmt, conn);
		}
		//����Ӱ������
		return rows;
	}
	/**
	 * ���տͻ���ţ������������ݿ���в�������
	 * @param cid �ͻ����
	 * @return �ͻ�ʵ�����
	 */
	@Override
	public Cust findById(String cid) {
		//�����ͻ�����
		Cust cust=null;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql�ַ���
			String sql="select cid,cname,sex,telphone,cardDate,rateMoney,eno from cust where cid=?";
			//ʹ�����ݿ����Ӷ���sql�ַ���ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��sql�ַ����в�����ֵ
			pstmt.setString(1, cid);
			//ִ��Ԥ���������󣬵õ������
			rs=pstmt.executeQuery();
			if(rs.next()){
				//ʵ�����ͻ�����
				cust=new Cust();
				//������������ݱ��浽�ͻ�������
				cust.setCid(rs.getString("cid"));
				cust.setCname(rs.getString("cname"));
				cust.setSex(rs.getString("sex"));
				//���ڸ�ʽת��
				cust.setTelphone(rs.getString("telphone"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				cust.setCardDate(sdf.format(rs.getDate("cardDate")));
				cust.setRateMoney(rs.getDouble("rateMoney"));
				cust.setEno(rs.getString("eno"));
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(rs, pstmt, conn);
		}
		//���ض���
		return cust;
	}
	/**
	 * ��ҳ����
	 * @param rows ����
	 * @param page ҳ��
	 * @return ָ��ҳ�е����ݼ���
	 */
	@Override
	public List<Cust> findByPage(int rows, int page) {
		//����ͻ����󼯺�
		List<Cust> custList=new ArrayList<Cust>();
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//��������Ӷ���
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="select * from cust limit ?,?";
			//ʹ�����ݿ����Ӷ���sql�ַ���ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��sql�ַ����в�����ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//ִ��Ԥ���������󣬵õ������
			rs=pstmt.executeQuery();
			//ʹ��ѭ����������
			while(rs.next()){
				//����ͻ�����
				Cust cust=new Cust();
				//������������ݱ��浽�ͻ�������
				cust.setCid(rs.getString("cid"));
				cust.setCname(rs.getString("cname"));
				cust.setSex(rs.getString("sex"));
				cust.setTelphone(rs.getString("telphone"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				cust.setCardDate(sdf.format(rs.getDate("cardDate")));
				cust.setRateMoney(rs.getDouble("rateMoney"));
				cust.setEno(rs.getString("eno"));
				//���ͻ�������ӵ��ͻ�������
				custList.add(cust);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(rs, pstmt, conn);
		}
		//���ؿͻ�����
		return custList;
	}
	/**
	 * ���ض�������ҳ����
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ��ѯ����
	 * @return ָ��ҳ�е����ݼ���
	 */
	@Override
	public List<Cust> findByPage(int rows, int page, String condition) {
		//����ͻ����϶���
		List<Cust> custList=new ArrayList<Cust>();
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql�ַ���
			String sql="select * from cust "+condition+" limit ?,?";
			//ʹ�����ݿ����Ӷ���sql�ַ���ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//��sql�ַ����еĲ�����ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//ִ��Ԥ���������󣬵õ������
			rs=pstmt.executeQuery();
			//ʹ��ѭ����������
			while(rs.next()){
				//����ͻ�����
				Cust cust=new Cust();
				//��������е����ݱ��浽�ͻ�������
				cust.setCid(rs.getString("cid"));
				cust.setCname(rs.getString("cname"));
				cust.setSex(rs.getString("sex"));
				cust.setTelphone(rs.getString("telphone"));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				cust.setCardDate(sdf.format(rs.getDate("cardDate")));
				cust.setRateMoney(rs.getDouble("rateMoney"));
				cust.setEno(rs.getString("eno"));
				//��������ӵ��ͻ�������
				custList.add(cust);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(rs, pstmt, conn);
		}
		//���ؿͻ�����
		return custList;
	}
	/**
	 * ͳ�������ݿ�������ݵ�������
	 * @return ����������
	 */
	@Override
	public int count() {
		//����Ӱ����������
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql�ַ���
			String sql="select count(*) from cust";
			//ʹ�����ݿ����Ӷ���sql�ַ���ʵ����������
			pstmt=conn.prepareStatement(sql);
			//ִ��Ԥ���������󣬵õ������
			rs=pstmt.executeQuery();
			//�жϽ����
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(rs, pstmt, conn);
		}
		//��������
		return rows;
	}
	/**
	 * ���ض�����ͳ�������ݿ���з�����������������
	 * @param condition ͳ������
	 * @return ���ط�����������������
	 */
	@Override
	public int count(String condition) {
		//����Ӱ����������
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����Ԥ����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="select count(*) from cust "+condition;
			//ʹ�����ݿ����Ӷ��� sql�ַ���ʵ����Ԥ����������
			pstmt=conn.prepareStatement(sql);
			//ִ��Ԥ����������õ������
			rs=pstmt.executeQuery();
			//�жϽ����
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر�
			JdbcUtils.close(rs, pstmt, conn);
		}
		//��������
		return rows;
	}

}
