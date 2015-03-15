package com.collect.alipay.service;

import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import net.sf.json.JSONArray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collect.alipay.domain.Distributor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:beans.xml" })
public class DistributorServiceTest {

	@Inject
	private DistributorService distributorService;

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {

		List<Distributor> list = distributorService.getAll(null);

		Distributor distributor = new Distributor();
		distributor.setId("0");
		distributor.setName("全部");
		distributor.setpId("-1");
		distributor.setOpen(true);

		list.add(distributor);
		
		
		System.out.println(JSONArray.fromObject(list).toString());
		
		
		
	}

	@Test
	public void testGetPager() {
		fail("Not yet implemented");
	}

}
