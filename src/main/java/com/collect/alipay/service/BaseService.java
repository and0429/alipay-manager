package com.collect.alipay.service;

import java.io.Serializable;

/**
 * 业务类的基础接口
 * 
 * @author zhangkai
 *
 */
public interface BaseService<T> {

	/**
	 * 保存对象
	 * 
	 * @param t
	 *            要保存的对象
	 */
	void save(T t);

	/**
	 * 根据Id删除对象
	 * 
	 * @param id
	 *            主键Id
	 */
	void delete(Serializable id);

	/**
	 * 更新对象
	 * 
	 * @param t
	 *            待更新的对象
	 */
	void update(T t);

	/**
	 * 根据Id查询一个实体
	 * 
	 * @param id
	 *            要查的Id
	 * @return 查询到了返回该实体。否则返回null；
	 */
	T getById(Serializable id);

	/**
	 * 查询记录数
	 * 
	 * @param condition
	 *            查询条件。不需要条件时传null;
	 * @return 查询到的记录数
	 */
	int getCount(T condition);

}
