package com.collect.alipay.domain;

import java.io.Serializable;

/**
 * 数据模型的基本类
 * 
 * @author zhangkai
 *
 */
public abstract class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 分页的开始
	 */
	private Integer start;

	/**
	 * 分页的长度
	 */
	private Integer length;

	/**
	 * 重画表格的次数
	 */
	private Integer draw;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

}
