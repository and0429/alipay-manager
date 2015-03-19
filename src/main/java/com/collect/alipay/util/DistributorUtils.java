package com.collect.alipay.util;

import java.util.ArrayList;
import java.util.List;

import com.collect.alipay.domain.Distributor;

/**
 * 用于处理分销商和子分销商的关系
 * 
 * @author zhangkai
 * 
 */
public class DistributorUtils {

	/**
	 * 指定一个集合。返回一个有树状结构的所有部门的集合
	 * 
	 * @param topList
	 * @return 新集合
	 */
	public static List<String> getAllNoChildDistributorById(List<Distributor> all, String id) {
		List<String> list = new ArrayList<String>();

		getAllNoChildDistributorById(all, list, id);

		return list;
	}

	/**
	 * 根据Id
	 * 
	 * @param disList
	 * @param distribuotrIdList
	 * @param id
	 */
	public static void getAllNoChildDistributorById(List<Distributor> disList, List<String> distribuotrIdList, String id) {

		for (int i = 0; i < disList.size(); i++) {
			Distributor distributor = disList.get(i);
			if (!id.equals(distributor.getId())) {
				continue;
			}
			// no child distributor
			if (distributor.getHasChild() == 0) {
				distribuotrIdList.add(id);
			} else {
				for (int j = 0; j < disList.size(); j++) {
					Distributor distributor2 = disList.get(j);
					if (distributor.getId().equals(distributor2.getpId())) {
						getAllNoChildDistributorById(disList, distribuotrIdList, distributor2.getId());
					}
				}
			}
		}
	}

}
