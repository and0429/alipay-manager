package com.collect.alipay.domain;


/**
 * 用户模型
 * 
 * @author zhangkai
 * 
 */
public class Cust extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 分销商Id
	 */
	private Distributor distributor;
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 负责人姓名
	 */
	private String manager;

	/**
	 * 联系电话
	 */
	private String tel;

	/**
	 * 地址
	 */
	private String addr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
