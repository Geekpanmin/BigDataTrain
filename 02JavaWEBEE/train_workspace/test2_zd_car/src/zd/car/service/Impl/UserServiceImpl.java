package zd.car.service.Impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zd.car.base.Page;
import zd.car.bean.Company;
import zd.car.bean.User;
import zd.car.constant.SysConstant;
import zd.car.dao.CompanyMapper;
import zd.car.dao.UserMapper;
import zd.car.service.UserService;
import zd.car.util.DateUtil;
import zd.car.vo.LoginVo;
import zd.car.vo.RegisterVo;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private CompanyMapper companyMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User t) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(t);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User t) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateByPrimaryKey(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUserByLoginNameAndPassword(LoginVo vo) {
		// TODO Auto-generated method stub
		User user = userMapper.findUserByLoginNameAndPassword(vo);
		return user;
	}

	@Override
	public List<User> findByPageQuery(Page<User> page) {
		// TODO Auto-generated method stub
		return userMapper.findByPageQuery(page);
	}

	@Override
	public int findTotalRowsByPageQuery(Page<User> page) {
		// TODO Auto-generated method stub
		return userMapper.findTotalRowsByPageQuery(page);
	}

	@Override
	public User findUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginName(loginName) ;
	}

	@Override
	public User findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return userMapper.findUserByPhone(phone);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userMapper.findUserByEmail( email);
	}

	@Override
	public void addRegister(RegisterVo vo) {
		// TODO Auto-generated method stub
		Company company=new Company();
		company.setAddress(vo.getAddress());
		company.setBoss(vo.getUsername());
		company.setCompanyCode(UUID.randomUUID().toString());
		company.setCompanyName(vo.getCompanyname());
		company.setCreateTime(DateUtil.now());
		company.setManageStyle(Integer.parseInt(vo.getManageStyle()));
		company.setManageDetail(vo.getManageDetail());
		company.setPhone(vo.getTelnum());
		company.setQq(vo.getQq());
		company.setStatus(SysConstant.COMPANY_STATUS_NORMAL);
		company.setTel1(vo.getTel1());
		company.setTel2(vo.getTel2());
		company.setZone1(vo.getZone1());
		company.setZone2(vo.getZone2());
		companyMapper.insertSelective(company);
		//插入用户
		User user=new User();
		user.setCompanyId(company.getId());
		user.setCreateTime(DateUtil.now());
		user.setEmail(vo.getEmail());
		user.setLevel(SysConstant.USER_LEVEL_BOSS);
		user.setLoginName(vo.getLoginName());
		user.setPassword(vo.getPassword());
		user.setPhone(vo.getTelnum());
		user.setQq(vo.getQq());
		user.setRoleId(SysConstant.USER_ROLE_BOSS);
		user.setStatus(SysConstant.USER_STATUS_NORMAL);
		user.setUsername(vo.getUsername());
		userMapper.insertSelective(user);
	}

	@Override
	public User findUserByLoginNameAndEmail(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUserByLoginNameAndEmail(user);
	}

}
