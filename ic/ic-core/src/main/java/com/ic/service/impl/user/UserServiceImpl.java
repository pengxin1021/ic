package com.ic.service.impl.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.ic.dao.BaseMapper;
import com.ic.dao.user.UserMapper;
import com.ic.entity.user.User;
import com.ic.service.impl.BaseServiceImpl;
import com.ic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public BaseMapper<User, Long> getMapper() {
		return userMapper;
	}

	@Override
	public User getUserByName(String name) {
		return userMapper.selectUserByName(name);
	}

}
