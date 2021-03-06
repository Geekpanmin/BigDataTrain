package zd.mypool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import zd.demo.MyDbUtils;

public class MyDataPool {
	//创建一个池子 里面放Connection对象
	List<Connection> list=new LinkedList<Connection>();
	//创建对象时 池子中有一定数量的连接
	public MyDataPool() throws Exception{
		for(int i=0;i<5;i++){
			Connection conn=MyDbUtils.getConnection();
			list.add(conn);
		}
	}
	//从池子中获取连接
	public Connection getConnection() throws SQLException {
		if(list.size()==0){
			for(int i=0;i<5;i++){
				Connection conn=MyDbUtils.getConnection();
				list.add(conn);
			}
		}
		Connection conn=list.remove(0);
		return conn;
	}
	//将连接归还到池子中
	public void addBack(Connection conn) throws SQLException {
		if(list.size()>8){
			conn.close();
		}
		list.add(conn);
	}

}
