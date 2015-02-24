package com.collect.alipay.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.collect.alipay.control.dto.BaseDto;
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
	public Map<String, Object> getPager(BaseDto baseDto) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<User> list = this.getByCondition(baseDto);
		int total = this.getCount(null);

		map.put("draw", baseDto.getDraw());
		map.put("data", list);
		map.put("recordsTotal", total);
		map.put("recordsFiltered", total);

		return map;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.collect.alipay.service.UserService#getByCondition(com.collect.alipay
	 * .control.dto.BaseDto)
	 */
	@Override
	public List<User> getByCondition(BaseDto baseDto) {
		return sqlSession.selectList(User.class.getName() + ".getByCondition", baseDto);
	}

}
