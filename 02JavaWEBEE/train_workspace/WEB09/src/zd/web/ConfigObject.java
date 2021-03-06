package zd.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigObject
 */
public class ConfigObject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfigObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		//获取初始化参数
		String a=config.getInitParameter("a");
		System.out.println(a);
		//获取所有的初始化参数的name
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name);
		}
	}

}
