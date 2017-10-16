package zd.car.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zd.car.bean.Brand;
import zd.car.bean.City;
import zd.car.bean.Company;
import zd.car.bean.Parts;
import zd.car.bean.Prime;
import zd.car.bean.User;
import zd.car.service.BrandService;
import zd.car.service.CityService;
import zd.car.service.CompanyService;
import zd.car.service.PartsService;
import zd.car.service.PrimeService;
import zd.car.service.UserService;
import zd.car.util.JsonUtils;
import zd.car.vo.RegisterVo;

@Controller
@RequestMapping("/register")
public class RegisterAction {
	@Resource
	private CompanyService companyService;
	@Resource
	private CityService cityService;
	@Resource
	private BrandService brandService;
	@Resource
	private PartsService partsService;
	@Resource
	private PrimeService primeService;
	@Resource
	private UserService userService;

	/**
	 * 注册功能
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/register.shtml")
	public void register(RegisterVo vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		userService.addRegister(vo);
		response.sendRedirect(request.getContextPath() + "/login/tologin.shtml");
	}

	/**
	 * 查询所有的省
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/getProvince.shtml")
	public void getProvince(HttpServletResponse response) throws Exception {
		// 查询到所有的省，并以json格式响应给客户端
		response.setCharacterEncoding("utf-8");
		List<City> list = cityService.findAllProvinces();
		String json = JsonUtils.List2Json(list);
		response.getWriter().write(json);

	}

	/**
	 * 获取市或者区域
	 */

	@RequestMapping("/getCity.shtml")
	public void getCity(int id, HttpServletResponse response) throws Exception {
		// 查询到所有的省，并以json格式响应给客户端
		response.setCharacterEncoding("utf-8");
		List<City> list = cityService.findCityByParentId(id);
		String json = JsonUtils.List2Json(list);
		response.getWriter().write(json);

	}

	@RequestMapping("/checkCompanyname.shtml")
	public void checkCompanyname(String companyname, HttpServletResponse response) throws Exception {
		// 根据企业名称查询企业表
		Company company = companyService.findCompanyByName(companyname);
		if (company == null) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}

	}

	@RequestMapping("/checkPhone.shtml")
	public void checkPhone(String telnum, HttpServletResponse response) throws Exception {
		// 校验手机号是否存在
		User user = userService.findUserByPhone(telnum);
		if (user == null) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}

	/**
	 * 校验邮箱是否可以注册
	 */
	@RequestMapping("/checkEmail.shtml")
	public void checkEmail(String email, HttpServletResponse response) throws Exception {
		// 校验手机号是否存在
		User user = userService.findUserByEmail(email);
		if (user == null) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}

	@RequestMapping("/checkLoginName.shtml")
	public void checkLoginName(String loginName, HttpServletResponse response) throws Exception {
		User user = userService.findUserByLoginName(loginName);
		if (user == null) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}

	@RequestMapping("/toRegister.shtml")
	public String toRegister(HttpServletRequest request) {
		List<Brand> brandList = brandService.findAllBrand();
		List<Parts> partsList = partsService.findAllParts();
		List<Prime> primeList = primeService.findAllPrime();
		request.setAttribute("brandList", brandList);
		request.setAttribute("partsList", partsList);
		request.setAttribute("primeList", primeList);
		return "commons/register";
	}
}
