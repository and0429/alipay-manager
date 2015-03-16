package com.collect.alipay.domain;

/**
 * 商户模型
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
	 * 名称
	 */
	private String name;
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 负责人
	 */
	private String manager;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 所属分销商
	 */
	private Distributor distributor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

}
