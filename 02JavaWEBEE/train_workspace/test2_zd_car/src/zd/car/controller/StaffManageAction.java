package zd.car.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zd.car.base.Page;
import zd.car.base.Pager;
import zd.car.bean.User;
import zd.car.constant.SysConstant;
import zd.car.service.UserService;
import zd.car.util.DateUtil;

@Controller
@RequestMapping("/staffManage")
public class StaffManageAction {
	@Resource
	private UserService userService;

	@RequestMapping("/addStaffManage")
	public String addStaffManage(User user, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		user.setCompanyId(sessionUser.getCompanyId());
		user.setCreateTime(DateUtil.now());
		user.setLevel(SysConstant.USER_LEVEL_STAFF);
		user.setRoleId(SysConstant.USER_ROLE_STAFF);
		user.setStatus(SysConstant.USER_STATUS_NORMAL);
		userService.insertSelective(user);
		return "commons/close";
	}

	@RequestMapping("/toAddStaffManage")
	public String toAddStaffManage() {
		return "staffManage/addStaff";
	}

	@RequestMapping("/staffList.shtml")
	public String staffList(Page page, User user, HttpSession session, HttpServletRequest request) {
		if (page.getPager() == null) {
			Pager pager = new Pager();
			page.setPager(pager);
		}
		User sessionUser = (User) session.getAttribute("user");
		user.setCompanyId(sessionUser.getCompanyId());
		page.setT(user);
		List<User> userList = userService.findByPageQuery(page);
		int totalRows = userService.findTotalRowsByPageQuery(page);
		page.setList(userList);
		page.setTotalRows(totalRows);
		request.setAttribute("page", page);
		return "staffManage/staffList";
	}
}
