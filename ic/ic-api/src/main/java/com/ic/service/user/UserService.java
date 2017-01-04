package com.ic.service.user;

import com.ic.entity.user.User;
import com.ic.service.BaseService;

public interface UserService extends BaseService<User, Long>{

	User getUserByName(String name);
}
