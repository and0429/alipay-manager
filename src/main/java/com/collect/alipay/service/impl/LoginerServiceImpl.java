/**
 * 
 */
package com.collect.alipay.service.impl;

import javax.inject.Named;

import com.collect.alipay.domain.Loginer;
import com.collect.alipay.service.LoginerService;

/**
 * @author zhangkai
 *
 */
@Named
public class LoginerServiceImpl extends BaseServiceImpl<Loginer> implements LoginerService {

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

}
