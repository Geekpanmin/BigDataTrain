package zd.service;

import java.sql.Connection;
import java.sql.SQLException;

import zd.dao.AccountDao;
import zd.utils.MyDbUtils;
import zd.utils.MyDbUtils2;

public class AccountService {
	AccountDao dao = new AccountDao();
	
	public void transfer(String from ,String to ,String money) throws SQLException{
		Connection conn = null ;
		try{
			//开启事务
			//从当前线程中获取连接
			conn = MyDbUtils2.getConnection();
			conn.setAutoCommit(false);
			//付款
			dao.pay(from, money);
			//int i = 1/0 ;
			//收款
			dao.inMoney(to, money);
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
		}
		
	}

}
