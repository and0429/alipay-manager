package com.collect.alipay.service;

import com.collect.alipay.domain.Distributor;

/**
 * 分销商业务接口
 * 
 * @author zhangkai
 *
 */
public interface DistributorService extends BaseService<Distributor> {

	/**
	 * 保存实体和更新父级的haschild
	 * 
	 * @param distributor
	 *            传递参数的实体
	 * @return 保存后影响的行数
	 */
	int saveAndUpdateParentStatus(Distributor distributor);

}
