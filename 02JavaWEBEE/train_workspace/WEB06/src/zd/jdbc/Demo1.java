package zd.jdbc;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		//?characterEncoding=UTF8
		//获取连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2?characterEncoding=UTF8","root","");
		//获取执行SQL语句的对象
		Statement statement=conn.createStatement();
		String sql="insert into products values(null,'c语言',100,'计算机',1000,'简单')";
		int i=statement.executeUpdate(sql);
		System.out.print(i);
		//释放资源
		statement.close();
		conn.close();
	}

}
