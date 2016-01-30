package com.tianyuan.xl.shop.dao;

import org.springframework.stereotype.Repository;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.shop.entity.Goods;

/**
 * 商品DAO
 * @author ty
 * @date 2015年1月22日
 */
@Repository
public class GoodsDao extends HibernateDao<Goods, Integer>{

}
