package com.fruit.manage.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUserRole<M extends BaseUserRole<M>> extends Model<M> implements IBean {

	public void setUserId(java.lang.Integer userId) {
		set("user_id", userId);
	}

	public java.lang.Integer getUserId() {
		return getInt("user_id");
	}

	public void setRoleId(java.lang.Integer roleId) {
		set("role_id", roleId);
	}

	public java.lang.Integer getRoleId() {
		return getInt("role_id");
	}

}