package com.collect.alipay.control;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collect.alipay.control.dto.Status;
import com.collect.alipay.domain.User;
import com.collect.alipay.service.UserService;

/**
 * 用户的控制器类
 * 
 * @author zhangkai
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Inject
	private UserService userService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Object user(@PathVariable String id) {
		int result = userService.delete(id);
		return new Status(result);
	}

	/**
	 * 用户列表
	 * 
	 * @return 组装好的表格数据
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public Object users(User user) {
		return userService.getPager(user);
	}
}
