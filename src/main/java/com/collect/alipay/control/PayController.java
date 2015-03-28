package com.collect.alipay.control;

import javax.inject.Inject;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.collect.alipay.domain.Loginer;
import com.collect.alipay.domain.Pay;
import com.collect.alipay.service.PayService;

/**
 * 支付业务的控制器
 * 
 * @author zhangkai
 *
 */
@RestController
@RequestMapping(value = "/pay")
@SessionAttributes("loginer")
public class PayController {

	@Inject
	private PayService payService;

	@RequestMapping(value = "/sellDetail", method = RequestMethod.POST)
	public Object sellDetail(Pay pay, ModelMap modelMap) {
		Loginer loginer = (Loginer) modelMap.get("loginer");
		if (loginer != null) {
			pay.setLoginer(loginer.getUsername());
		}
		return payService.getPager(pay);
	}

}
