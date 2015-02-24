package com.collect.alipay.control;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collect.alipay.domain.Loginer;
import com.collect.alipay.service.LoginerService;

/**
 * 登录控制器
 * 
 * @author zhangkai
 *
 */
@Controller
public class LoginController {

	public static final String LOGIN_ERROR = "用户名或密码错误";

	@Inject
	private LoginerService loginerService;

	/**
	 * 跳转到登录页面
	 * 
	 * @param loginer
	 *            登录对象
	 * @return 登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute Loginer loginer) {
		return "index";
	}

	/**
	 * 处理登录请求
	 * 
	 * @param loginer
	 *            登录数据对象
	 * @param br
	 *            验证错误信息
	 * @param session
	 *            会话对象
	 * @return 相应的页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute Loginer loginer, BindingResult br, HttpSession session) {
		if (br.hasErrors()) {
			return "index";
		}

		boolean result = loginerService.check(loginer);

		if (!result) {
			loginer.setLoginMessage(LOGIN_ERROR);
			return "index";
		}

		session.setAttribute("loginer", loginer);

		return "redirect:html/navigation.html";

	}

	/**
	 * 注销
	 * 
	 * @return 到登录页面
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginer");
		session.invalidate();
		return "redirect:login.do";
	}

	/**
	 * 获取当前的登录用户
	 * 
	 * @param session
	 *            httpSession
	 * @return 已经登录的用户或者null;
	 */
	@RequestMapping(value = "/getloginer", method = RequestMethod.GET)
	@ResponseBody
	public Loginer getLoginer(HttpSession session) {
		Loginer loginer = (Loginer) session.getAttribute("loginer");
		return loginer;
	}
}
