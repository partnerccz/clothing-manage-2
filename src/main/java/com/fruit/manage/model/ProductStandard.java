package com.fruit.manage.model;

import com.fruit.manage.model.base.BaseProductStandard;
import com.fruit.manage.util.Common;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class ProductStandard extends BaseProductStandard<ProductStandard> {
	public static final ProductStandard dao = new ProductStandard().dao();
	public static final int STATUS_USE = 1;
	public static final int STATUS_UNUSED = 0;
	public static final int STATUS_DELETE = -1;

	public List<ProductStandard> list(int productId, String prop, boolean desc) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,name,original_price,sell_price,");
		sql.append("weight_price,shipping_fee,purchase_quantity_min,purchase_quantity_max,");
		sql.append("buy_start_time,buy_end_time,status,is_default ");
		sql.append("FROM b_product_standard WHERE product_id=? and status!=-1 ");
		sql.append("order by ");
		sql.append(prop);
		if(desc) {
			sql.append(" desc ");
		}
		return find(sql.toString(), productId);
	}

	public boolean changeStatus(Integer[] productIds, int status) {
		Db.update("update b_product_standard set status=? where product_id in (" + Common.arrayToSqlIn(productIds) + ") ", status);
		return true;
	}

	public boolean changeStatusOne(int productId, Integer[] ids, int status) {
		return Db.tx(new IAtom() {
			@Override
			public boolean run() throws SQLException {
				Db.update("update b_product_standard set status=? where id in (" + Common.arrayToSqlIn(ids) + ")", status);
				if(status == STATUS_USE) {// 如果为启用并且商品为不启用状态，则设置商品为启用状态
					Db.update("update b_product set status=?,update_time=now() where id=? and status!=? "
							, Product.STATUS_USE, productId, Product.STATUS_USE);
				} else {// 如果规格没有上线状态的，则设置商品为下架状态
					StringBuilder sql = new StringBuilder();
					sql.append("UPDATE b_product p LEFT JOIN b_product_standard ps ON (ps.status=? AND p.id=ps.product_id) ")
							.append("SET p.status=?,p.update_time=now() ")
							.append("WHERE p.id=? AND p.status=? AND ps.id IS NULL ");
					Db.update(sql.toString(), STATUS_USE, Product.STATUS_UNUSED, productId, Product.STATUS_USE);
				}
				return true;
			}
		});

	}

	public boolean save(ProductStandard productStandard) {
		return Db.tx(new IAtom() {
			@Override
			public boolean run() throws SQLException {
				productStandard.setUpdateTime(new Date());
				if(productStandard.getIsDefault() == 1) {// 将其他默认规格去除
					Db.update("update b_product_standard set is_default=0 where product_id=?", productStandard.getProductId());
				}
				boolean result = false;
				if(productStandard.getId() != null) {
					result = productStandard.update();
				} else {
					productStandard.setCreateTime(new Date());
					result = productStandard.save();
				}
				if(!result) {
					return false;
				}
				Product product = Product.dao.getById(productStandard.getProductId());
				product.setUpdateTime(new Date());// 用于微信前端显示商品最近更新时间
				if(productStandard.getStatus() == STATUS_USE && product.getStatus() != Product.STATUS_USE) {// 如果为启用并且商品为不启用状态，则设置商品为启用状态
					product.setStatus(Product.STATUS_USE);
				}
				return product.update();
			}
		});
	}

// 修改完状态，刷新商品列表
	// 保存完也刷新列表

}
