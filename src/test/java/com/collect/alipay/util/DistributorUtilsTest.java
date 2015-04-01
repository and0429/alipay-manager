package com.collect.alipay.util;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collect.alipay.domain.Distributor;
import com.collect.alipay.service.DistributorService;

/**
 * 
 * @author zhangkai
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class DistributorUtilsTest {

	@Inject
	private DistributorService distributorService;
	
	@Test
	public void testGetAllNoChildDistributorById() {
		
		List<Distributor> all  = distributorService.getAll(null);
		List<String> ids = DistributorUtils.getAllNoChildDistributorById(all, "1d472927ac7d4d5ba2fc0e5e09f58513");
		
		for (String string : ids) {
			System.out.println(string);
		}
		
	}

	@Test
	public void testGetSelfAndChild() {
		List<Distributor> all  = distributorService.getAll(null);
		List<Distributor> newList =  DistributorUtils.getSelfAndChild(all, "a1a1b40e5f594677a1a27bbf30e11f53");
		
		for (Distributor distributor : newList) {
			System.out.println(distributor.getName());
		}
	}

}
