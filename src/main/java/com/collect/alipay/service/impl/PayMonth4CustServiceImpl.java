package com.collect.alipay.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.collect.alipay.control.dto.DataTableDto;
import com.collect.alipay.domain.Distributor;
import com.collect.alipay.domain.Loginer;
import com.collect.alipay.domain.PayMonth4Cust;
import com.collect.alipay.service.DistributorService;
import com.collect.alipay.service.PayMonth4CustService;
import com.collect.alipay.util.DistributorUtils;

/**
 * 商户支付月账单的业务实现类
 * 
 * @author zhangkai
 *
 */
@Named
public class PayMonth4CustServiceImpl extends BaseServiceImpl<PayMonth4Cust> implements PayMonth4CustService {
	
	@Inject
	private DistributorService DistributorService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.collect.alipay.service.PayMonth4CustService#getPager(com.collect.
	 * alipay.domain.PayMonth4Cust, com.collect.alipay.domain.Loginer)
	 */
	@Override
	public DataTableDto<PayMonth4Cust> getPager(PayMonth4Cust payMonth4Cust, Loginer loginer) {
		
		List<PayMonth4Cust> data = new ArrayList<PayMonth4Cust>();
		DataTableDto<PayMonth4Cust> dto = new DataTableDto<PayMonth4Cust>(payMonth4Cust.getDraw(), 0, data);
		
		if (loginer == null) {
			return dto;
		}
		
		if (loginer.getRole() == 3) {
			return dto;
		}
		
		String distributorId = loginer.getCustOrDistributorId();
		
		List<Distributor> allDistributors = DistributorService.getAll(null);
		List<String> custIds = DistributorUtils.getAllNoChildDistributorById(allDistributors, distributorId);
		
		整理map传参数
				
		
		
		
		
		
		
		return null;
	}

}
