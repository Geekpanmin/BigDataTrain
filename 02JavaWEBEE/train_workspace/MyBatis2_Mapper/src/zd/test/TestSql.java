package zd.test;

import java.util.List;

import org.junit.Test;

import zd.model.User;
import zd.service.UserService;
import zd.service.impl.UserServiceImpl;

public class TestSql {
	@Test
	public void testFindUserById() {
		UserService userService = new UserServiceImpl();
		User user = userService.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testFindUserByUsername() {
		UserService userService = new UserServiceImpl();
		List<User> list = userService.findUserByUsername("张");
		System.out.println(list);
	}
	@Test
	public void testAddUser() {
		UserService userService = new UserServiceImpl();
		User u=new User();
		u.setName("xd");
		u.setPwd("12");
		userService.addUser(u);
		System.out.println(u);
	}
	@Test
	public void testUpdateUser() {
		UserService userService = new UserServiceImpl();
		User u=new User();
		u.setId(7);
		u.setName("徐");
		u.setPwd("");
		userService.updateUser(u);
		System.out.println(u);
	}
	@Test
	public void testDeleteUserById() {
		UserService userService = new UserServiceImpl();
		userService.deleteUserById(7);
	}
	
}
