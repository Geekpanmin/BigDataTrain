package zd.c3p0;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import zd.beans.Product;

public class DemoCRUD {
	ComboPooledDataSource dataSource = null;
	QueryRunner runner = null;

	@Before
	public void init() {
		// 创建数据库连接池的连接
		dataSource = new ComboPooledDataSource();
		// 使用apache的工具类
		runner = new QueryRunner(dataSource);
	}

	@Test
	public void delete() throws SQLException {
		String sql="delete from products where id=?";
		runner.update(sql, "16");
	}

	@Test
	public void add() throws SQLException {
		String sql="insert into products values(null,?,?,?,?,?)";
		runner.update(sql, "大数据",13.07,"软件",190,"热门");
	}
	@Test
	public void update() throws SQLException {
		String sql="update products set name = ? where id=?";
		runner.update(sql, "云计算","19");
	}
	
	@Test
	public void select() throws SQLException {
		String sql="select * from products ";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		
	}

}
