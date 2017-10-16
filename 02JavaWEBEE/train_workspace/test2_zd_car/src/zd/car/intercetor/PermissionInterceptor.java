package zd.car.intercetor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import zd.car.bean.Menu;
import zd.car.bean.User;

public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("ctx", request.getContextPath());
	}

	/**
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestUri = request.getRequestURI();
		if (requestUri.contains("login") || requestUri.contains("register")) {
			return true;
		} else {
			HttpSession session = request.getSession(false);
			if (session == null) {
				response.sendRedirect(request.getContextPath() + "/login/tologin.shtml");
				return false;
			} else {
				if (session.getAttribute("user") == null) {
					response.sendRedirect(request.getContextPath() + "/login/tologin.shtml");
					return false;
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
						return true;
					} else {
						response.sendRedirect(request.getContextPath() + "/login/unauthorized.shtml");
						return false;
					}
				}
			}
		}

	}
}
