package zd.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import zd.bean.User;

public class UserDao {
	
	public User getUserByName(String name) throws SQLException{
		//使用c3p0 数据库连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		QueryRunner runner = new QueryRunner(dataSource);
		String sql = "select * from user where name = ?";
		User user = runner.query(sql, new BeanHandler<User>(User.class),name);
		return user;
	}

}
