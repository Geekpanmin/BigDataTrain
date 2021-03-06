package zd.request;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import zd.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//接收页面的参数   tomcat接收数据的时候使用的是iso8859-1 编码解
		String name = request.getParameter("name");
		//get请求出现了乱码
	   /*byte[] bs = name.getBytes("iso8859-1");
		String nnanm = new  String(bs, "UTF-8");*/
		
		String pwd = request.getParameter("pwd");
		//操作数据库
		//1  要有jar  配置文件
		//2 创建数据库连接池的对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//3使用阿帕奇的工具类
		QueryRunner runner = new QueryRunner(dataSource);
	    //写sql
		String sql ="select * from user1 where username=? and password=?" ;
		try {
			User user = runner.query(sql, new BeanHandler<User>(User.class), name,pwd);
			if(null!=user){//登录成功
				request.getRequestDispatcher("/success.html").forward(request, response);
			}else{//登录失败
				request.getRequestDispatcher("/login.html").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
