package com.collect.alipay.util;

import org.junit.Test;

import com.collect.alipay.wsclient.AlipayPayService;
import com.collect.alipay.wsclient.AlipayPayServiceImplService;
import com.collect.alipay.wsclient.PrecreateRequest;
import com.collect.alipay.wsclient.PrecreateResponse;

public class Wstest {

	@Test
	public void wsTest() {

		AlipayPayServiceImplService serivce = new AlipayPayServiceImplService();

		AlipayPayService alipay = serivce.getAlipayPayServiceImplPort();

		PrecreateRequest pr = new PrecreateRequest();

		pr.setProductCode("QR_CODE_OFFLINE");
		pr.setRemark("102");
		pr.setSubject("102");
		pr.setTotal("0.01");
		pr.setTradeNo("101100fdsfds02");
		pr.setUser("xcy");

		PrecreateResponse resp = alipay.alipayPrecreate(pr);

		System.out.println(resp.getBigPicUrl());

	}

}
