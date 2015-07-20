package com.kaloo.service.impl;

import java.util.List;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaloo.core.dataSource.annotation.DataSource;
import com.kaloo.domain.User;
import com.kaloo.integrace.dao.UserMapper;
import com.kaloo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int deleteByPrimaryKey(Long userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	@DataSource("master")
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int insertSelective(User record) {
		//return userMapper.insertSelective(record);
		int i = userMapper.insertSelective(record);
		if(i <= 0)
			throw new RuntimeException("插入数据不成功！");
		//List<User> userList = this.selectAll();
		/*System.err.println("===========" + AopUtils.isJdkDynamicProxy(AopContext.currentProxy()));
		List<User> userList = ((UserService)AopContext.currentProxy()).selectAll();
		System.err.println(userList.size());		
		for(User user : userList) {
			System.out.println(user.getUserId());
		}*/
		return i;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public User selectByPrimaryKey(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	@DataSource("master")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

}
