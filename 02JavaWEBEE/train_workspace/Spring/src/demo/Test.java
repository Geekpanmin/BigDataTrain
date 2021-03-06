package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zd.dao.UserDao;
import zd.model.User;
import zd.service.UserService;

public class Test {

	public static void main(String[] args) {
		// 实例化IOC容器,通过源路径的相对路径查找核心配置文件
		// IOC容器的本质就是一个Map,key是bean的唯一标示，value是bean对象本身
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
		/*
		 * //通过ioc容器去获取容器当中的bean UserService
		 * userServcie=(UserService)ioc.getBean("userService"); UserDao
		 * userDao=(UserDao)ioc.getBean(UserDao.class); //运行对象的方法
		 * userServcie.sayHello(); userDao.sayHello(); User
		 * user=(User)ioc.getBean("user"); System.out.println(user); User
		 * user1=(User)ioc.getBean("user1"); System.out.println(user1);
		 */
		UserService userService = ioc.getBean(UserService.class);
		UserDao userDao = ioc.getBean(UserDao.class);
		userService.sayHello();
		userDao.sayHello();
		User user = (User) ioc.getBean("user");
		System.out.println(user);

	}

}
