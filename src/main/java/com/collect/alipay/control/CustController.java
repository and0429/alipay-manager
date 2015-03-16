package com.collect.alipay.control;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collect.alipay.control.dto.Status;
import com.collect.alipay.domain.Cust;
import com.collect.alipay.service.CustService;

/**
 * 用户的控制器类
 * 
 * @author zhangkai
 *
 */
@RestController
@RequestMapping(value = "/cust")
public class CustController {

	@Inject
	private CustService custService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Object user(@PathVariable String id) {
		int result = custService.delete(id);
		return new Status(result);
	}

	/**
	 * 用户列表
	 * 
	 * @return 组装好的表格数据
	 */
	@RequestMapping(value = "/custs", method = RequestMethod.POST)
	public Object users(Cust cust) {
		if (cust.getName() != null) {
			cust.setName(cust.getName().trim());
		}
		return custService.getPager(cust);
	}
}
