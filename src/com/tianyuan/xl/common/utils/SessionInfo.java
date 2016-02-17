package com.tianyuan.xl.common.utils;

import java.util.List;

@SuppressWarnings("serial")
public class SessionInfo implements java.io.Serializable {

	private String id;// 用户ID
	private String loginname;// 登录名
	private String name;// 姓名
	private String ip;// 用户IP
	private String userDeptId;
	private String entityDeptId;
	private String currentUserRoleId;

	private List<String> resourceList;// 用户可以访问的资源地址列表
	
	private List<String> resourceAllList;

	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	public List<String> getResourceAllList() {
		return resourceAllList;
	}

	public void setResourceAllList(List<String> resourceAllList) {
		this.resourceAllList = resourceAllList;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getUserDeptId() {
		return userDeptId;
	}

	public void setUserDeptId(String userDeptId) {
		this.userDeptId = userDeptId;
	}

	public String getEntityDeptId() {
		return entityDeptId;
	}

	public void setEntityDeptId(String entityDeptId) {
		this.entityDeptId = entityDeptId;
	}

	public String getCurrentUserRoleId() {
		return currentUserRoleId;
	}

	public void setCurrentUserRoleId(String currentUserRoleId) {
		this.currentUserRoleId = currentUserRoleId;
	}

}
