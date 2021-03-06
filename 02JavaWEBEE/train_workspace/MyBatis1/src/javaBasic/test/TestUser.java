package javaBasic.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestUser {
	@Test
	public void testInsert() throws Exception{
		InputStream in=Resources.getResourceAsStream("MyBatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		User user=new User();
		//user.setId(4);
		user.setName("张丹");
		user.setPwd("123");
		session.insert("user.insertUser", user);
		session.commit();
		session.close();
		System.out.println(user);
	}
	@Test
	public void testUpdate() throws Exception{
		InputStream in=Resources.getResourceAsStream("MyBatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		User user=new User();
		user.setId(2);
		user.setName("徐朝晖");
		session.update("user.updateUser", user);
		session.commit();
		session.close();
		
	}
}
