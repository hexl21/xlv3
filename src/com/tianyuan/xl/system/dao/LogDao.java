package com.tianyuan.xl.system.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.system.entity.Log;


/**
 * 日志DAO
 * @author xl
 * @date 2015年1月13日
 */
@Repository
public class LogDao extends HibernateDao<Log, Serializable>{
	
	/**
	 * 批量删除日志
	 * @param ids 日志id列表
	 */
	public void deleteBatch(List<String> idList){
		String hql="delete from Log log where log.id in (:idList)";
		Query query=getSession().createQuery(hql);
		query.setParameterList("idList", idList);
		query.executeUpdate();
	}
}
