package com.tianyuan.xl.system.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.tianyuan.xl.common.persistence.HibernateDao;
import com.tianyuan.xl.system.entity.Dict;

/**
 * 字典DAO
 * @author xl
 * @date 2015年1月13日
 */
@Repository
public class DictDao extends HibernateDao<Dict, Serializable>{

}
