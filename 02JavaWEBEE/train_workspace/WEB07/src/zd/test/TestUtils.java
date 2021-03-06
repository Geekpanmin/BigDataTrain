package zd.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import zd.demo.MyDbUtils;

public class TestUtils {
	Connection conn=null;
	 Statement st=null;
	//先test 后before
	@Before
	public void init() throws SQLException{
		 conn=MyDbUtils.getConnection();
		 st=conn.createStatement();
	}
	@Test
	public void add() throws SQLException{
		//配置文件
		String sql="insert into products values(null,'数据结构',12.09,'计算机',1000,'掌握，适用广')";
		int i=st.executeUpdate(sql);
		System.out.println(i);
		//必须关闭 否则测试错误
		//即使下面有错误 也可以执行  因为是单元测试
		MyDbUtils.release(conn, st, null);
	}
	@Test
	public void delete() throws SQLException{
		//配置文件
		String sql="delete from products where id = 13";
		int i=st.executeUpdate(sql);
		System.out.println(i);
		MyDbUtils.release(conn, st, null);
	}
	@Test
	public void update() throws SQLException{
		//配置文件
		String sql="update products set name = '操作系统' where id = 11";
		int i=st.executeUpdate(sql);
		System.out.println(i);
		MyDbUtils.release(conn, st, null);
	}
	@Test
	public void select() throws SQLException{
		//配置文件
		String sql="select * from products";
		ResultSet set=st.executeQuery(sql);
		while(set.next()){
			String id=set.getString("id");
			String name=set.getString(2);
			System.out.println(id+"="+name);
		}
		MyDbUtils.release(conn, st, set);
	}
}
