package com.fruit.manage.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseProductStandard<M extends BaseProductStandard<M>> extends Model<M> implements IBean {

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

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return getStr("name");
	}

	public void setSubTitle(String subTitle) {
		set("sub_title", subTitle);
	}

	public String getSubTitle() {
		return getStr("sub_title");
	}

	public void setOriginalPrice(java.math.BigDecimal originalPrice) {
		set("original_price", originalPrice);
	}

	public java.math.BigDecimal getOriginalPrice() {
		return get("original_price");
	}

	public void setSellPrice(java.math.BigDecimal sellPrice) {
		set("sell_price", sellPrice);
	}

	public java.math.BigDecimal getSellPrice() {
		return get("sell_price");
	}

	public void setWeightPrice(java.math.BigDecimal weightPrice) {
		set("weight_price", weightPrice);
	}

	public java.math.BigDecimal getWeightPrice() {
		return get("weight_price");
	}

	public void setCostPrice(java.math.BigDecimal costPrice) {
		set("cost_price", costPrice);
	}

	public java.math.BigDecimal getCostPrice() {
		return get("cost_price");
	}

	public void setShippingFee(java.math.BigDecimal shippingFee) {
		set("shipping_fee", shippingFee);
	}

	public java.math.BigDecimal getShippingFee() {
		return get("shipping_fee");
	}

	public void setCartonWeight(Double cartonWeight) {
		set("carton_weight", cartonWeight);
	}

	public Double getCartonWeight() {
		return getDouble("carton_weight");
	}

	public void setFruitWeight(Double fruitWeight) {
		set("fruit_weight", fruitWeight);
	}

	public Double getFruitWeight() {
		return getDouble("fruit_weight");
	}

	public void setGrossWeight(Double grossWeight) {
		set("gross_weight", grossWeight);
	}

	public Double getGrossWeight() {
		return getDouble("gross_weight");
	}

	public void setPurchaseQuantityMin(Integer purchaseQuantityMin) {
		set("purchase_quantity_min", purchaseQuantityMin);
	}

	public Integer getPurchaseQuantityMin() {
		return getInt("purchase_quantity_min");
	}

	public void setPurchaseQuantityMax(Integer purchaseQuantityMax) {
		set("purchase_quantity_max", purchaseQuantityMax);
	}

	public Integer getPurchaseQuantityMax() {
		return getInt("purchase_quantity_max");
	}

	public void setBuyStartTime(java.util.Date buyStartTime) {
		set("buy_start_time", buyStartTime);
	}

	public java.util.Date getBuyStartTime() {
		return get("buy_start_time");
	}

	public void setBuyEndTime(java.util.Date buyEndTime) {
		set("buy_end_time", buyEndTime);
	}

	public java.util.Date getBuyEndTime() {
		return get("buy_end_time");
	}

	public void setSortPurchase(Integer sortPurchase) {
		set("sort_purchase", sortPurchase);
	}

	public Integer getSortPurchase() {
		return getInt("sort_purchase");
	}

	public void setSortSoldOut(Integer sortSoldOut) {
		set("sort_sold_out", sortSoldOut);
	}

	public Integer getSortSoldOut() {
		return getInt("sort_sold_out");
	}

	public void setSortSplit(Integer sortSplit) {
		set("sort_split", sortSplit);
	}

	public Integer getSortSplit() {
		return getInt("sort_split");
	}

	public void setStock(Integer stock) {
		set("stock", stock);
	}

	public Integer getStock() {
		return getInt("stock");
	}

	public void setStatus(Integer status) {
		set("status", status);
	}

	public Integer getStatus() {
		return getInt("status");
	}

	public void setIsDefault(Integer isDefault) {
		set("is_default", isDefault);
	}

	public Integer getIsDefault() {
		return getInt("is_default");
	}

	public void setPurchaserUid(Integer purchaserUid) {
		set("purchaser_uid", purchaserUid);
	}

	public Integer getPurchaserUid() {
		return getInt("purchaser_uid");
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
