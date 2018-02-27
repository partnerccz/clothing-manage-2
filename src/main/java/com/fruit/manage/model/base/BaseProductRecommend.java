package com.fruit.manage.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseProductRecommend<M extends BaseProductRecommend<M>> extends Model<M> implements IBean {

	public void setId(Integer id) {
		set("id", id);
	}

	public Integer getId() {
		return getInt("id");
	}

	public void setProductId(Integer productId) {
		set("product_id", productId);
	}

	public Integer getProductId() {
		return getInt("product_id");
	}

	public void setType(Integer type) {
		set("type", type);
	}

	public Integer getType() {
		return getInt("type");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

}
