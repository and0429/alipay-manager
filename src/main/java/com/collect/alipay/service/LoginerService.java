/**
 * 
 */
package com.collect.alipay.service;

import java.util.List;

import com.collect.alipay.domain.Loginer;

/**
 * 登录业务接口
 * 
 * @author zhangkai
 *
 */
public interface LoginerService extends BaseService<Loginer> {

	/**
	 * 验证登录用户是否有效
	 * 
	 * @param loginer
	 *            登录用户
	 * @return 正确返回true，否则返回false;
	 */
	boolean check(Loginer loginer);

	/**
	 * 根据用户名查找一个实体
	 * 
	 * @param username
	 *            用户名
	 * @return 返回查询到的实体，否则返回null
	 */
	Loginer getByUsername(String username);

	/**
	 * 获取Ztree的数据
	 * 
	 * @return
	 */
	List<Object> getZtreeData();

	/**
	 * 根据条件获取登陆者列表
	 * 
	 * @param loginer
	 *            封装条件
	 * @return dataTables数据载体
	 */
	Object getLoginers(Loginer loginer);

}
