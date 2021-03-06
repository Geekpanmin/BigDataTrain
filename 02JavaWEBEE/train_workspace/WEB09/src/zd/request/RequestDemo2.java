package zd.request;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//接收多个值的参数
		/*
		String[] values = request.getParameterValues("hobby");
		for (String string : values) {
			System.out.println("hobby="+string);
		}*/
		//获取所有的参数   并且不知道key（name）
		Map<String, String[]> map = request.getParameterMap();
		//遍历map
		Set<Entry<String,String[]>> set = map.entrySet();
		//遍历set
		for (Entry<String, String[]> entry : set) {
			String key = entry.getKey();
			String[] value = entry.getValue();
			for (String string : value) {
				System.out.println(key+":"+string);
			}
		}
	}
}
