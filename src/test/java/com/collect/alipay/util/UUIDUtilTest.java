package com.collect.alipay.util;

import org.junit.Test;

public class UUIDUtilTest {

	@Test
	public void testRandomUUID() {
		
		String uuid = UUIDUtil.randomUUID();
		System.out.println(uuid);
		
	}
	

}
