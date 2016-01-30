package com.tianyuan.xl.system.dao;

import java.io.Serializable;

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

}
