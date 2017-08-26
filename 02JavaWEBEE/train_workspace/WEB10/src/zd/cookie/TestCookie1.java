package zd.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestCookie1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String str="张丹";
        String encode = URLEncoder.encode(str, "UTF-8");
        //cookie不能存汉字
        //Cookie cookie=new Cookie("name", "zd");
        Cookie cookie=new Cookie("name", encode);
        //cookie.setPath("/WEB10");
        //一个小时
        //cookie.setMaxAge(60*60);
        //返回给浏览器
        response.addCookie(cookie);
        
    }

}