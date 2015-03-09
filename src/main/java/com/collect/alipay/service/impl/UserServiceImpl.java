package com.collect.alipay.service.impl;

import java.util.List;

import javax.inject.Named;

import com.collect.alipay.control.dto.DataTableDto;
import com.collect.alipay.domain.User;
import com.collect.alipay.service.UserService;

/**
 * 用户业务实现类
 * 
 * @author zhangkai
 *
 */
@Named
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.collect.alipay.service.UserService#getPager(com.collect.alipay.control
	 * .dto.BaseDto)
	 */
	@Override
	public DataTableDto<User> getPager(User user) {

		List<User> list = this.getAll(user);
		int total = this.getCount(user);

		return new DataTableDto<User>(user.getDraw(), total, list);

	}

}
