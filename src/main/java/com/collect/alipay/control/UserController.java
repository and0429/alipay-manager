package com.collect.alipay.control;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collect.alipay.control.dto.BaseDto;
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

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Object user(@PathVariable String id) {

		User u = userService.getById(id);

		return u;

	}

	/**
	 * 用户列表
	 * 
	 * @return 组装好的表格数据
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Object users(BaseDto baseDto) {

		Map<String, Object> map = userService.getPager(baseDto);
		return map;
	}
}
