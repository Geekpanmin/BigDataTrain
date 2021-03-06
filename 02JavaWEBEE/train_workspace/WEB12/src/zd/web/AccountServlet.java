package zd.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zd.service.AccountService;

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountService service = new AccountService();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//1.解析请求 获取页面请求数据
		String from = request.getParameter("from");//付款人
		String to = request.getParameter("to");//收款人
		String money = request.getParameter("money");//金额
		//2 调用service
		try {
			service.transfer(from, to, money);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
