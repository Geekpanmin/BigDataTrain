package zd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JdbcDemo {
	/*
	 * 1.创建一个java项目
	 * 2.导入 jar包  build path
	 * 3.注册驱动
	 * 4.获取连接 对象
	 * 5.获取执行sql语句的对象
	 * 6.如果是查询，应该有结果集 封装结果集
	 */
	
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new Driver());
		//获取连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2?characterEncoding=UTF8","root","");
		//获取执行SQL语句的对象
		Statement statement=conn.createStatement();
		String sql="select * from products";
		ResultSet set=statement.executeQuery(sql);
		while(set.next()){
			String name=set.getString("id");
			System.out.println(name);
		}
		statement.close();
	}
	
	
}
