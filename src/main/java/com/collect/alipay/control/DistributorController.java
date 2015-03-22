package com.collect.alipay.control;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collect.alipay.control.dto.Status;
import com.collect.alipay.domain.Cust;
import com.collect.alipay.domain.Distributor;
import com.collect.alipay.service.CustService;
import com.collect.alipay.service.DistributorService;

/**
 * 分销商管理控制器
 * 
 * @author zhangkai
 *
 */
@RestController
@RequestMapping("/distributor")
public class DistributorController {

	@Inject
	private DistributorService distributorService;

	@Inject
	private CustService custService;

	/**
	 * 获取Ztree数据
	 * 
	 * @return 数据集合
	 */
	@RequestMapping(value = "/getTree", method = RequestMethod.GET)
	public Object getAllDistributor() {

		List<Distributor> list = distributorService.getAll(null);

		Distributor distributor = new Distributor();
		distributor.setId("0");
		distributor.setName("西北总代理");
		distributor.setpId("-1");
		distributor.setHasChild(1);
		distributor.setOpen(true);

		list.add(distributor);

		return list;
	}

	/**
	 * 获取所有的分销商
	 * 
	 * @param flag
	 *            标志
	 * @return 获去到的集合
	 */
	@RequestMapping(value = "/getSelect", method = RequestMethod.GET)
	public Object getAllDistributor(String getSelect) {
		return distributorService.getAll(null);
	}

	
	/**
	 * 获取所有的分销商
	 * 
	 * @param flag
	 *            标志
	 * @return 获去到的集合
	 */
	@RequestMapping(value = "/getSelect/{parentId}", method = RequestMethod.GET)
	public Object getDistributor(@PathVariable String parentId) {
		return distributorService.getByParentId(parentId);
	}
	
	/**
	 * 增加一个实体
	 * 
	 * @param distributor
	 *            待增加的实体
	 * @return 状态
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(Distributor distributor) {
		int result = distributorService.saveAndUpdateParentStatus(distributor);
		return new Status(result);
	}

	/**
	 * 根据Id删除实体
	 * 
	 * @param id
	 *            id
	 * @return 状态
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Object delete(@PathVariable String id) {

		List<Cust> custs = custService.getByDistributorId(id);
		if (custs.size() > 0) {
			return new Status(0, "该分销商下有商户，不能删除！");
		}
		int rusult = distributorService.delete(id);
		return new Status(rusult);
	}

	/**
	 * 根据Id获取实体
	 * 
	 * @param id
	 *            id
	 * @return 查询到的实体
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Object getById(@PathVariable String id) {

		Distributor d = distributorService.getById(id);

		System.out.println(d);

		return d;
	}

	/**
	 * 更行实体
	 * 
	 * @param distributor
	 *            待更新
	 * @return 更新状态
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(Distributor distributor) {
		int result = distributorService.update(distributor);
		return new Status(result);
	}

}
