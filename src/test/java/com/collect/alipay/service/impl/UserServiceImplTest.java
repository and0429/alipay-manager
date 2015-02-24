package com.collect.alipay.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collect.alipay.domain.Distributor;
import com.collect.alipay.domain.User;
import com.collect.alipay.service.UserService;
import com.collect.alipay.util.UUIDUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class UserServiceImplTest {

	@Inject
	private UserService service;

	@Test
	public void test_001_Save() {

		User u = new User();
		String id = UUIDUtil.randomUUID();

		u.setId(id);
		u.setAddr("addr");
		u.setDistributor(new Distributor());
		u.setManager("管理者manager");
		u.setTel("18192830300");
		u.setUsername("username");

		service.save(u);

		User u2 = service.getById(id);
		assertNotNull(u2);
		assertEquals("18192830300", u2.getTel());
		
		u2.setAddr("更新后的");
		u2.setManager("更新后的manage");
		
		service.update(u2);

		User u3 = service.getById(id);
		assertNotNull(u3);
		assertEquals("更新后的manage", u3.getManager());
		
		
		service.delete(id);
		User u4 = service.getById(id);
		assertNull(u4);
		
		
		
	}

	@Test
	public void test_002_Update() {
	}

	@Test
	public void test_003_Delete() {
	}

}
