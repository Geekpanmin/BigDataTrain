package com.eems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eems.entity.User;
import com.eems.util.DBUtil;



public class UserDao extends DBUtil{
	//查询是否为合法用户
	public boolean findAll(User user) {
		boolean flag = false;
		String sql = "select * from user where name=? and pwd=?";

		ResultSet rs = this.executeQuery(sql,user.getName(),user.getPwd());
		try {
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
