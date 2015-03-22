package com.collect.alipay.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.collect.alipay.control.dto.DataTableDto;
import com.collect.alipay.domain.Cust;
import com.collect.alipay.domain.Distributor;
import com.collect.alipay.domain.Loginer;
import com.collect.alipay.service.CustService;
import com.collect.alipay.service.DistributorService;
import com.collect.alipay.service.LoginerService;

/**
 * @author zhangkai
 *
 */
@Named
public class LoginerServiceImpl extends BaseServiceImpl<Loginer> implements LoginerService {

	@Inject
	private DistributorService disService;

	@Inject
	private CustService custService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.collect.alipay.service.LoginerService#check(com.collect.alipay.domain
	 * .Loginer)
	 */
	@Override
	public boolean check(Loginer loginer) {

		Loginer loginerResult = sqlSession.selectOne(clazz.getName() + ".check", loginer);

		if (loginerResult != null) {
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.collect.alipay.service.LoginerService#getByUsername(java.lang.String)
	 */
	@Override
	public Loginer getByUsername(String username) {
		return sqlSession.selectOne(clazz.getName() + ".getByUsername", username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.LoginerService#getZtreeData()
	 */
	@Override
	public List<Object> getZtreeData() {

		List<Distributor> list = disService.getAll(null);

		Distributor distributor = new Distributor();
		distributor.setId("0");
		distributor.setName("西北总代理");
		distributor.setpId("-1");
		distributor.setHasChild(1);
		distributor.setOpen(true);

		list.add(distributor);

		List<Cust> custs = custService.getAll(null);

		List<Object> result = new ArrayList<Object>();
		result.addAll(list);
		result.addAll(custs);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.collect.alipay.service.LoginerService#getLoginers(com.collect.alipay
	 * .domain.Loginer)
	 */
	@Override
	public Object getLoginers(Loginer loginer) {

		DataTableDto<Loginer> dataTables = this.getPager(loginer);

		List<Loginer> loginers = dataTables.getData();

		for (Loginer loginer2 : loginers) {

			switch (loginer2.getRole()) {
			case 2:
				Distributor dis = disService.getById(loginer2.getCustOrDistributorId());
				loginer2.setCustOrDistributorName(dis.getName());
				break;
			case 3:
				Cust cust = custService.getById(loginer2.getCustOrDistributorId());
				loginer2.setCustOrDistributorName(cust.getName());
				break;
			}
		}

		return dataTables;
	}

}
