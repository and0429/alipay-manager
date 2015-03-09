package com.collect.alipay.domain;

import org.hibernate.validator.constraints.NotEmpty;

/****
 * 登陆者模型
 * 
 * @author zhangkai
 *
 */
public class Loginer extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	/***
	 * 用户名
	 */
	@NotEmpty(message = "用户名不能为空")
	private String username;

	/**
	 * 密码
	 */
	@NotEmpty(message = "密码不能为空")
	private String password;

	/**
	 * 登录信息
	 */
	private String loginMessage;

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
