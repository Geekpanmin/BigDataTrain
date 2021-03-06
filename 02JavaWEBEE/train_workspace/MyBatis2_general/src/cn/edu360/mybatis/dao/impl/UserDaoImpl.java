package cn.edu360.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.edu360.mybatis.dao.UserDao;
import cn.edu360.mybatis.model.User;
import cn.edu360.mybatis.util.MybatisUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		SqlSession session=MybatisUtil.getFactory().openSession();
		return session.selectOne("cn.edu360.mybatis.dao.UserDao.findUserById", id);
	}

	@Override
	public List<User> findUserByUsername(String name) {
		SqlSession session=MybatisUtil.getFactory().openSession();
		return session.selectList("cn.edu360.mybatis.dao.UserDao.findUserByUsername", name);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		SqlSession session=MybatisUtil.getFactory().openSession();
		session.insert("cn.edu360.mybatis.dao.UserDao.addUser", user);
		//增删改必须commit
		session.commit();
	}

}
