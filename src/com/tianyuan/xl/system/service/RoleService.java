package com.tianyuan.xl.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.common.service.BaseService;
import com.tianyuan.xl.system.dao.RoleDao;
import com.tianyuan.xl.system.entity.Role;

/**
 * 角色service
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly = true)
public class RoleService extends BaseService<Role, String> {

	@Autowired
	private RoleDao roleDao;

	@Override
	public HibernateDao<Role, String> getEntityDao() {
		return roleDao;
	}
}
