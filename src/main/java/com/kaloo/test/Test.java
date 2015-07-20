package com.kaloo.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaloo.domain.User;
import com.kaloo.service.UserService;
import com.kaloo.util.DateUtil;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config/*.xml");
		context.start();
		UserService userService = context.getBean(UserService.class);
		User user = new User();
		user.setUserName("lwj");
		user.setUserBirthday(DateUtil.parseDate("19860323"));
		user.setUserSalary(30000.00);
		user.setCreateTime(new Date());
		userService.insertSelective(user);
		/*PageHelper.startPage(1, 2, "user_id desc");
		List<User> userList = userService.selectAll();
		System.err.println(userList.size());		
		for(User user : userList) {
			System.out.println(user.getUserId());
		}
		System.out.println(new PageInfo<User>(userList).toString());*/
		context.close();
	}

}
