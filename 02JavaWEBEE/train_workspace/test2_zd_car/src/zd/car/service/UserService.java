package zd.car.service;

import zd.car.base.BaseService;
import zd.car.bean.User;
import zd.car.vo.LoginVo;
import zd.car.vo.RegisterVo;

public interface UserService extends BaseService<User> {

	User findUserByLoginNameAndPassword(LoginVo vo);

	User findUserByLoginName(String loginName);

	User findUserByPhone(String phone);

	User findUserByEmail(String email);

	void addRegister(RegisterVo vo);

	User findUserByLoginNameAndEmail(User user);
}
