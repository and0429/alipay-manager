package com.collect.alipay.service;

import com.collect.alipay.control.dto.DataTableDto;
import com.collect.alipay.domain.Loginer;
import com.collect.alipay.domain.PayMonth4Cust;

/**
 * 商户支付月账单的业务接口
 * 
 * @author zhangkai
 *
 */
public interface PayMonth4CustService extends BaseService<PayMonth4Cust> {

	/**
	 * 
	 * @param payMonth4Cust
	 * @param loginer
	 * @return
	 */
	DataTableDto<PayMonth4Cust> getPager(PayMonth4Cust payMonth4Cust, Loginer loginer);

}
