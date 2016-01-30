package com.tianyuan.xl.system.service;

import java.io.Serializable;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.common.service.BaseService;
import com.tianyuan.xl.system.dao.RolePermissionDao;
import com.tianyuan.xl.system.entity.Permission;
import com.tianyuan.xl.system.entity.Role;
import com.tianyuan.xl.system.entity.RolePermission;

/**
 * 角色权限service
 * @author ty
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly=true)
public class RolePermissionService extends BaseService<RolePermission, Serializable> {
	
	@Autowired
	private RolePermissionDao rolePermissionDao;
	
	@Override
	public HibernateDao<RolePermission, Serializable> getEntityDao() {
		return rolePermissionDao;
	}
	
	/**
	 * 获取角色权限id集合
	 * @param id
	 * @return List
	 */
	public List<String> getPermissionIds(String roleId){
		return rolePermissionDao.findPermissionIds(roleId);
	}
	
	/**
	 * 修改角色权限
	 * @param id
	 * @param oldList
	 * @param newList
	 */
	@Transactional(readOnly = false)
	public void updateRolePermission(String id,List<String> oldList,List<String> newList){
		//是否删除
		for(int i=0,j=oldList.size();i<j;i++){
			if(!newList.contains(oldList.get(i))){
				rolePermissionDao.deleteRP(id,oldList.get(i));
			}
		}
		
		//是否添加
		for(int i=0,j=newList.size();i<j;i++){
			if(!oldList.contains(newList.get(i))){
				rolePermissionDao.save(getRolePermission(id,newList.get(i)));
			}
		}
	}
	
	/**
	 * 清空该角色用户的权限缓存
	 */
	public void clearUserPermCache(PrincipalCollection pc){
		RealmSecurityManager securityManager =  (RealmSecurityManager) SecurityUtils.getSecurityManager();
		UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
	    userRealm.clearCachedAuthorizationInfo(pc);
	}
	
	/**
	 * 构造角色权限对象
	 * @param roleId
	 * @param permissionId
	 * @return RolePermission
	 */
	private RolePermission getRolePermission(String roleId,String permissionId){
		RolePermission rp=new RolePermission();
		rp.setRole(new Role(roleId));
		rp.setPermission(new Permission(permissionId));
		return rp;
	}
	
}
