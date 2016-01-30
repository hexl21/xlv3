package com.tianyuan.xl.system.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.system.entity.UserRole;


/**
 * 用户角色DAO
 * @author xl
 * @date 2015年1月13日
 */
@Repository
public class UserRoleDao extends HibernateDao<UserRole, Serializable>{

	/**
	 * 删除用户角色
	 * @param userId
	 * @param roleId
	 */
	public void deleteUR(String userId,String roleId){
		String hql="delete UserRole ur where ur.user.id=?0 and ur.role.id=?1";
		batchExecute(hql, userId,roleId);
	}
	
	/**
	 * 查询用户拥有的角色id集合
	 * @param userId
	 * @return 结果集合
	 */
	@SuppressWarnings("unchecked")
	public List<String> findRoleIds(String userId){
		String hql="select ur.role.id from UserRole ur where ur.user.id=?0";
		Query query= createQuery(hql, userId);
		return query.list();
	}
	
}
