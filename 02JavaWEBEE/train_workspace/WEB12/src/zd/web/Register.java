package zd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zd.service.UserService;

import zd.bean.User;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   UserService service  = new UserService() ;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			//接收参数
			String name = request.getParameter("name");
			//System.out.println(name);
			User user = service.getUserByName(name);
			if(null==user){//用户名不存在
				response.getWriter().write("用户名可用");
			}else{
				response.getWriter().write("用户名已经存在");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
