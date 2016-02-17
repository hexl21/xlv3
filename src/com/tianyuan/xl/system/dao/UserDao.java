package com.tianyuan.xl.system.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.system.entity.User;


/**
 * 用户DAO
 * @author xl
 * @date 2015年1月13日
 */
@Repository
public class UserDao extends HibernateDao<User, Serializable>{
	/**
	 * 查询用户信息
	 * @param userName 用户name
	 * @return user
	 */
	public User getUserInfo(String userName){
		StringBuffer sb=new StringBuffer();
		sb.append("select u.* from user u ");
		sb.append("where u.id=?0");
		SQLQuery sqlQuery=createSQLQuery(sb.toString(), userName);
		sqlQuery.addEntity(User.class);
		//sqlQuery.setCacheable(true);
		User user = (User)sqlQuery.list().get(0);
		return user;
	}
}
