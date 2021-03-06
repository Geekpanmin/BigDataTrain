package zd.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Demo2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		//读取配置文件
		InputStream in=Demo2.class.getClassLoader().getResourceAsStream("config/db.properties");
		//创建工具类
		Properties p=new Properties();
		p.load(in);
		String driverClass=p.getProperty("driverClass");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		//注册驱动
		Class.forName(driverClass);
		Connection conn=DriverManager.getConnection(url,username,password);
		Statement statement=conn.createStatement();
		String sql="delete from products where id=10";
		int i=statement.executeUpdate(sql);
		System.out.print(i);
		statement.close();
		conn.close();
	}

}
