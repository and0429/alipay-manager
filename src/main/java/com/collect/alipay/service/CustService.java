package com.collect.alipay.service;

import com.collect.alipay.control.dto.DataTableDto;
import com.collect.alipay.domain.Cust;

/**
 * 用户业务接口
 * 
 * @author zhangkai
 *
 */
public interface CustService extends BaseService<Cust> {

	/**
	 * 产讯条件封装成Map作为参数
	 * 
	 * @param cust
	 *            封装参数
	 * @param distributorId
	 *            分销商Id
	 * @return table对象
	 */
	DataTableDto<Cust> getPagerWithMapCodition(Cust cust, String distributorId);

}
