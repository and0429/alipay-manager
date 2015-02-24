/**
 * 
 */
package com.collect.alipay.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;

import com.collect.alipay.service.BaseService;

/**
 * 业务类的基础接口实现类
 * 
 * @author zhangkai
 *
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Inject
	@Named("sqlSession")
	protected SqlSession sqlSession;

	protected Class<T> clazz;

	/**
	 * 构造方法
	 */
	@SuppressWarnings("unchecked")
	protected BaseServiceImpl() {

		if (clazz == null) {

			ParameterizedType pf = (ParameterizedType) this.getClass().getGenericSuperclass();
			Type[] types = pf.getActualTypeArguments();

			clazz = (Class<T>) types[0];
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(T t) {
		sqlSession.insert(clazz.getName() + ".save", t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		sqlSession.delete(clazz.getName() + ".delete", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(T t) {
		sqlSession.delete(clazz.getName() + ".update", t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.collect.alipay.service.BaseService#getById(java.io.Serializable)
	 */
	@Override
	public T getById(Serializable id) {
		return sqlSession.selectOne(clazz.getName() + ".getById", id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 */
	@Override
	public int getCount(T condition) {

		if (condition == null) {
			return sqlSession.selectOne(clazz.getName() + ".getCount");
		} else {
			return sqlSession.selectOne(clazz.getName() + ".getCountWithCondition", condition);
		}

	}

}
