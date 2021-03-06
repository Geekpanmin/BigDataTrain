package zd.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zd.dao.UserDao;
import zd.model.User;
import zd.service.UserService;
import zd.utils.MyBatisUtils;

public class UserServiceImpl implements UserService {

	@Override
	public User findUserById(int id) {
		// session=事务 每次都需要更新
		SqlSession session = MyBatisUtils.getFactory().openSession();
		UserDao daili = session.getMapper(UserDao.class);
		/**
		 * session.getMapper方法是通过mybatis框架获取传入类型的接口的代理实现类对象
		 * 代理实现类当中封装了如何找到mapper文件,如果通过方法名找到对应的sql（statement） 又包括了查询结果集到model的映射
		 */
		User user = daili.findUserById(id);
		return user;
	}

	@Override
	public List<User> findUserByUsername(String name) {
		SqlSession session = MyBatisUtils.getFactory().openSession();
		UserDao daili = session.getMapper(UserDao.class);
		List<User> list = daili.findUserByUsername(name);
		return list;
	}

	@Override
	public void updateUser(User user) {
		SqlSession session = MyBatisUtils.getFactory().openSession();
		UserDao daili = session.getMapper(UserDao.class);
		daili.updateUser(user);
		// 增删改必须commit
		session.commit();
	}

	@Override
	public void addUser(User user) {
		SqlSession session = MyBatisUtils.getFactory().openSession();
		UserDao daili = session.getMapper(UserDao.class);
		daili.addUser(user);
		// 增删改必须commit
		session.commit();
	}

	@Override
	public void deleteUserById(int id) {
		// session=事务 每次都需要更新
		SqlSession session = MyBatisUtils.getFactory().openSession();
		UserDao daili = session.getMapper(UserDao.class);
		daili.deleteUserById(id);
		session.commit();
	}

}
