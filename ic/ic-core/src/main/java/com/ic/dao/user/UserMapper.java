package com.ic.dao.user;

import com.ic.dao.BaseMapper;
import com.ic.entity.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User, Long> {

	User selectUserByName(String name);

}
