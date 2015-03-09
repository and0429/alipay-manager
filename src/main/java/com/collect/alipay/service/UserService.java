package com.collect.alipay.service;

import com.collect.alipay.control.dto.DataTableDto;
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
	DataTableDto<User> getPager(User user);

}
