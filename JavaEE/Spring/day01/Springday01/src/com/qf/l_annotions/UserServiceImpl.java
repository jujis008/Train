package com.qf.l_annotions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/**
 * @Component(value="userService")
 * 就相当于：
 * <bean id="userService" class="com.qf.l_annotions.UserServiceImpl"></bean>
 * @author tomcat
 *
 */
//@Component(value="userService")
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
	/**
	 * @Autowired
	@Qualifier(value="userDao")
		按照名字注入
		
		注解可以不要setter方法
	 */
	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;

	@Override
	public void sayHlleo() {
		// TODO Auto-generated method stub
		System.out.println("say Hello~~~");
		userDao.say();
	}

}
