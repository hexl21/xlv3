package com.tianyuan.xl.system.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.common.service.BaseService;
import com.tianyuan.xl.system.dao.DictDao;
import com.tianyuan.xl.system.entity.Dict;

/**
 * 字典service
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class DictService extends BaseService<Dict, Serializable> {
	
	@Autowired
	private DictDao dictDao;

	@Override
	public HibernateDao<Dict, Serializable> getEntityDao() {
		return dictDao;
	}
}
