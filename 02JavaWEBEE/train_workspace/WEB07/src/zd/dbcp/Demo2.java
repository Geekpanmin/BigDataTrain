package zd.dbcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.load(new FileInputStream("src/dncp.properties"));
		BasicDataSourceFactory dataSourceFactory = new BasicDataSourceFactory();
		DataSource dataSource = BasicDataSourceFactory.createDataSource(p);
		Connection conn = dataSource.getConnection();
		// sql语句对象
		String sql = "update newUser set username=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);           
		ps.setString(1, "zd");
		ps.setString(2, "4");
		int i=ps.executeUpdate();
		System.out.println(i);
		ps.close();
		conn.close();

	}
}
