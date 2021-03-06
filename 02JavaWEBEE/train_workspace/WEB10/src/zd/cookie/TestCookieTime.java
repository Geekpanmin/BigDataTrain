package zd.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestCookieTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		/*
		// 先往cookie中放当前时间
		long millis = System.currentTimeMillis();
		// 放值
		Cookie cookie = new Cookie("time", millis + "");
		// 返回给浏览器
		response.addCookie(cookie);
		*/
		// 取数据
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookieTime : cookies) {
				if ("time".equals(cookieTime.getName())) {
					String value = cookieTime.getValue();
					//转换long类型
					long t = Long.parseLong(value);
					Date date = new Date(t);
					response.getWriter().write("你上次访问的时间是："+date.toLocaleString());
				}
			}
		}else{
			// 先往cookie中放当前时间
			long millis = System.currentTimeMillis();
			// 放值
			Cookie cookie = new Cookie("time", millis + "");
			// 返回给浏览器
			response.addCookie(cookie);
			//浏览器清楚所有数据
			response.getWriter().write("你是第一次访问");
		}
	}   
    

}
