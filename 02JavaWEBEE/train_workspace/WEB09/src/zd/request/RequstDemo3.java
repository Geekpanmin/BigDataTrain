package zd.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequstDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//作为一个域对象   作用的范围是一次请求
		//1 向域中放数据
		request.setAttribute("name", "cjx");
		//2 从域中取数据
		String  attribute = (String)request.getAttribute("name");
		System.out.println(attribute);
		request.getRequestDispatcher("/RequstDemo4").forward(request, response);
	}

}
