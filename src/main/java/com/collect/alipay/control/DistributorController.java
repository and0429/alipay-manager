package com.collect.alipay.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分销商管理控制器
 * @author zhangkai
 *
 */
@RestController
@RequestMapping("/distributor")
public class DistributorController {

	@RequestMapping(value = "/getTree", method = RequestMethod.GET)
	public Object getAllDistributor(){
		
		String s = "[{id:1, pId:0, name: \"父节点1\"},{id:11, pId:1, name: \"子节点1\"},{id:12, pId:1, name: \"子节点2\"}]";
		
		return s;
	}
	
	
	
}
