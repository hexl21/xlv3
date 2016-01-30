package com.tianyuan.xl.system.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.system.entity.RolePermission;


/**
 * 角色权限DAO
 * @author xl
 * @date 2015年1月13日
 */
@Repository
public class RolePermissionDao extends HibernateDao<RolePermission, Serializable>{
	
	/**
	 * 查询角色拥有的权限id
	 * @param roleId
	 * @return 结果集合
	 */
	@SuppressWarnings("unchecked")
	public List<String> findPermissionIds(String roleId){
		String hql="select rp.permission.id from RolePermission rp where rp.role.id=?0";
		Query query= createQuery(hql, roleId);
		return query.list();
	}

	/**
	 * 删除角色权限
	 * @param roleId
	 * @param permissionId
	 */
	public void deleteRP(String roleId,String permissionId){
		String hql="delete RolePermission rp where rp.role.id=?0 and rp.permission.id=?1";
		batchExecute(hql, roleId,permissionId);
	}
	
	
}
