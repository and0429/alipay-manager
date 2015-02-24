package com.collect.alipay.service;

import java.util.List;
import java.util.Map;

import com.collect.alipay.control.dto.BaseDto;
import com.collect.alipay.domain.User;

/**
 * 用户业务接口
 * 
 * @author zhangkai
 *
 */
public interface UserService extends BaseService<User> {

	/**
	 * 获取分页数据
	 * 
	 * @param baseDto
	 *            数据传输对象
	 * @return 数据Map
	 */
	Map<String, Object> getPager(BaseDto baseDto);

	/**
	 * 获取条件数据
	 * 
	 * @param baseDto
	 *            数据传输对象
	 * @return 数据集合
	 */
	List<User> getByCondition(BaseDto baseDto);

}
