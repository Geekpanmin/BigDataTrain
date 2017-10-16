package zd.car.intercetor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import zd.car.bean.Menu;
import zd.car.bean.User;


public class PermMethodInterceptor implements MethodInterceptor {

	/**
	 */
	public Object invoke(MethodInvocation chain) throws Throwable {
		ServletWebRequest servletContainer = (ServletWebRequest) RequestContextHolder
				.getRequestAttributes();
		// TODO Auto-generated method stub
		HttpServletRequest request = servletContainer.getRequest();
		HttpServletResponse response = servletContainer.getResponse();
		Object result = null;
		String requestUri = request.getRequestURI();
		if (requestUri.contains("login") || requestUri.contains("register")) {
			result = chain.proceed();
		} else {
			HttpSession session = request.getSession(false);
			if (session == null) {
				response.sendRedirect(request.getContextPath()
						+ "/login/tologin.shtml");

			} else {
				if (session.getAttribute("user") == null) {
					response.sendRedirect(request.getContextPath()
							+ "/login/tologin.shtml");
				} else {
					User user = (User) session.getAttribute("user");
					List<Menu> menuList = user.getMenus();
					boolean checkPermission = false;
					for (Menu menu : menuList) {
						if (requestUri.contains(menu.getPermissionCode())) {
							checkPermission = true;
							break;
						}
					}
					if (checkPermission) {
						result = chain.proceed();
					} else {
						response.sendRedirect(request.getContextPath()
								+ "/login/unauthorized.shtml");
					}
				}
			}

		}
		return result;
	}
}