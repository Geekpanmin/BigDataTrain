package zd.context;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContext2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        ServletContext context =this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("WEB-INF/1.html");
        dispatcher.forward(request, response);
    }

}