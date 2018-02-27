package com.fruit.manage.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBanner<M extends BaseBanner<M>> extends Model<M> implements IBean {

	public void setId(Integer id) {
		set("id", id);
	}

	public Integer getId() {
		return getInt("id");
	}

	public void setGroupKey(String groupKey) {
		set("group_key", groupKey);
	}

	public String getGroupKey() {
		return getStr("group_key");
	}

	public void setKey(String key) {
		set("key", key);
	}

	public String getKey() {
		return getStr("key");
	}

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return getStr("name");
	}

	public void setSort(Integer sort) {
		set("sort", sort);
	}

	public Integer getSort() {
		return getInt("sort");
	}

	public void setDes(String des) {
		set("des", des);
	}

	public String getDes() {
		return getStr("des");
	}

	public void setImgUrl(String imgUrl) {
		set("img_url", imgUrl);
	}

	public String getImgUrl() {
		return getStr("img_url");
	}

	public void setClickUrl(String clickUrl) {
		set("click_url", clickUrl);
	}

	public String getClickUrl() {
		return getStr("click_url");
	}

	public void setStatus(Integer status) {
		set("status", status);
	}

	public Integer getStatus() {
		return getInt("status");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}
