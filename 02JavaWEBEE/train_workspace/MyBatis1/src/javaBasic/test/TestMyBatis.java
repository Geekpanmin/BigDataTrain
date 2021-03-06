package javaBasic.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMyBatis {
	public static void main(String[] args) throws IOException {
		//配置文件
		InputStream in=Resources.getResourceAsStream("MyBatis.xml");
		//创建SqlSessionFactory对象，相当于数据库连接池
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		//工厂生产一个SqlSession，叫做会话对象 
		//mybatis框架会把一次连接connection当作一次会话
		SqlSession session=factory.openSession();
		//操作数据库
		session.delete("user.deleteUserById", 1);
		List<User> userList=session.selectList("user.selectUserByUsername", "张");
		for(User u : userList){
			System.out.println(u);
		}
		//注意：mybatis框架默认非自动提交事务
		//session.commit();
	}

}
