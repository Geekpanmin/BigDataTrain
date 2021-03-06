package nuc.sw.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.sw.bean.manager;
import nuc.sw.dao.ManagerDao;
import nuc.sw.dbc.DBUtil;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		request.setCharacterEncoding("utf-8");
		//将用户名密码封装到manager中
		manager m=new manager();
		m.setUsername(request.getParameter("username"));
		m.setPassword(request.getParameter("password"));
		m.setDept(request.getParameter("dept"));
		m.setName(request.getParameter("name"));
		m.setScount(request.getParameter("scount"));
		ManagerDao mDao=new ManagerDao();
		if(mDao.doInsert(m)){
		//注册信息,将信息放到session中
			request.getSession().setAttribute("username",request.getParameter("username"));
			request.getSession().setAttribute("password",request.getParameter("password"));
			request.getSession().setAttribute("dept",request.getParameter("dept"));
			request.getSession().setAttribute("name",request.getParameter("name"));
			request.getSession().setAttribute("scount",request.getParameter("scount"));					
			
			//服务器跳转到userLoginPage.jsp
			//注册成功
			request.getRequestDispatcher("manShowPage.jsp").forward(request,response);	
		}
		else{
			 //注册错误信息
			request.setAttribute("error", "注册信息错误，请重新输入");
			//服务器跳转到login.jsp
			//request.getRequestDispatcher("register.jsp").forward(request,response);	
		   
		}
	}

}
