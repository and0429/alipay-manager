package com.collect.alipay.control.dto;

/**
 * 数据传输对象基础类
 * 
 * @author zhangkai
 *
 */
public class BaseDto {

	/**
	 * dataTable请求次数
	 */
	private int draw;

	/**
	 * 每页显示条数
	 */
	private int length;

	/**
	 * 记录开始数
	 */
	private int start;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
