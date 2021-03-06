package zd.c3p0;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import zd.beans.Product;

public class Demo2 {

	public static void main(String[] args) throws SQLException {
		//创建数据库连接池的连接
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//使用apache的工具类
		QueryRunner runner=new QueryRunner(dataSource);
		String sql="select * from products where id=?";
		//返回一条结果
		Product pro=runner.query(sql, new BeanHandler<Product>(Product.class), "1");
		System.out.println(pro);
		//不需要任何操作 自动会关闭
	}
}
