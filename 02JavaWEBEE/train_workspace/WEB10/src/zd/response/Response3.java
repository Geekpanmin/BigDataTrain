package zd.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Response3 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //状态吗
        response.setStatus(302);
        //响应头
        //response.setHeader("location", "/WEB10/send.html");
        request.setAttribute("name", "zd");
        //重定向：两次请求 需要项目名 地址栏变化 request中的内容不会转发 实现页面跳转
        response.sendRedirect("/WEB10/send.html");
        //response.sendRedirect("/WEB10/Response4");
    }

}