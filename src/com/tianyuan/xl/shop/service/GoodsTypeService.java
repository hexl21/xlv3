package com.tianyuan.xl.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.common.service.BaseService;
import com.tianyuan.xl.shop.dao.GoodsTypeDao;
import com.tianyuan.xl.shop.entity.GoodsType;

/**
 * 商品类型service
 * @author ty
 * @date 2015年1月22日
 */
@Service
@Transactional(readOnly=true)
public class GoodsTypeService extends BaseService<GoodsType, Integer> {
	
	@Autowired
	private GoodsTypeDao goodsTypeDao;

	@Override
	public HibernateDao<GoodsType, Integer> getEntityDao() {
		return goodsTypeDao;
	}

}
