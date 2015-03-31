package com.collect.alipay.service;

import java.util.UUID;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collect.alipay.domain.Loginer;
import com.collect.alipay.util.UUIDUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class LoginerServiceTest {

	@Inject
	private LoginerService service;

	@Test
	public void testCheck() {

		Loginer loginer = new Loginer();

		String id = UUIDUtil.randomUUID();
	

		loginer.setId(id);
		loginer.setPassword("password");
		loginer.setUsername("username");

		service.save(loginer);

		boolean flag = service.check(loginer) != null;

		Assert.assertEquals(true, flag);

		service.delete(id);

	}
	
	
	@Test
	public void test2(){
		
		int i  =UUID.randomUUID().toString().length();
		System.out.print(i);
	}

}
