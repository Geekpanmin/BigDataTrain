package zd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import zd.utils.MyDbUtils;
import zd.utils.MyDbUtils2;

public class AccountDao {
	
	/**
	 * 付款
	 * @throws SQLException 
	 */
	public void pay(String from , String money) throws SQLException{
		//1 获取连接
		Connection conn = MyDbUtils2.getConnection();
		//获取操作sql语句的对象
		String sql = "update transfer set money=money-? where name = ?" ;
		PreparedStatement ps = conn.prepareStatement(sql);
		//编译sql语句
		ps.setString(1, money);
		ps.setString(2, from);
		//执行
		ps.executeUpdate();
		MyDbUtils.release(null, ps, null);
	}
	/**
	 * 收款
	 * @throws SQLException 
	 */
	public void inMoney(String to , String money) throws SQLException{
		//1 获取连接
		Connection conn = MyDbUtils2.getConnection();
		//获取操作sql语句的对象
		String sql = "update transfer set money=money+? where name = ?" ;
		PreparedStatement ps = conn.prepareStatement(sql);
		//编译sql语句
		ps.setString(1, money);
		ps.setString(2, to);
		//执行
		ps.executeUpdate();
		MyDbUtils.release(null, ps, null);
	}

}
