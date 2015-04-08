package com.collect.alipay.util;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collect.alipay.wsclient.AlipayPayService;
import com.collect.alipay.wsclient.PrecreateRequest;
import com.collect.alipay.wsclient.PrecreateResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class Wstest {

	@Inject
	private AlipayPayService service;

	@Test
	public void wsTest() {

		PrecreateRequest pr = new PrecreateRequest();

		pr.setProductCode("QR_CODE_OFFLINE");
		pr.setRemark("102");
		pr.setSubject("102");
		pr.setTotal("0.01");
		pr.setTradeNo("101100fdsfds02");
		pr.setUser("xcy");

		PrecreateResponse resp = service.alipayPrecreate(pr);

		System.out.println(resp.getBigPicUrl());

	}

}
