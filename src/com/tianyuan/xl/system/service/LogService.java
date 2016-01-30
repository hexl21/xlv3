package com.tianyuan.xl.system.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.common.service.BaseService;
import com.tianyuan.xl.system.dao.LogDao;
import com.tianyuan.xl.system.entity.Log;

/**
 * 日志service
 * @author ty
 * @date 2015年1月14日
 */
@Service
@Transactional(readOnly=true)
public class LogService extends BaseService<Log, Serializable> {
	
	@Autowired
	private LogDao logDao;
	
	@Override
	public HibernateDao<Log, Serializable> getEntityDao() {
		return logDao;
	}
	
	/**
	 * 批量删除日志
	 * @param idList
	 */
	@Transactional(readOnly=false)
	public void deleteLog(List<String> idList){
		logDao.deleteBatch(idList);
	}
	
}
