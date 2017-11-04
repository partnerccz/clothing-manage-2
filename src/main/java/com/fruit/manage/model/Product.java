package com.fruit.manage.model;

import com.fruit.manage.model.base.BaseProduct;
import com.fruit.manage.util.Common;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Product extends BaseProduct<Product> {

	public static final Product dao = new Product().dao();

	public Page<Record> page(Integer pageNum, Integer pageSize, Integer productId, String productName, Integer status, Date start, Date end, String orderProp, String orderType) {
		if(pageNum == null || pageNum <= 0) {
			pageNum = 1;
		}
		if(pageSize == null || pageSize <= 0) {
			pageSize = 100;
		}
		if(pageSize > 1000) {
			pageSize = 1000;
		}
		String selectSql = "SELECT id,name,country,brand,fruit_type,sort,fresh_time,fresh_expire_time,fruit_des,store_way,create_time,update_time,total_sell_num,week_sell_num,status ";
		List<Object> params = new ArrayList<>();
		StringBuilder sql = new StringBuilder("FROM b_product WHERE 1=1 ");
		if(productId != null) {
			sql.append("AND id=? ");
			params.add(productId);
		}
		if(StrKit.notBlank(productName)) {
			sql.append("AND name like ? ");
			params.add("%" + productName + "%");
		}
		if(status != null) {
			sql.append("AND status=? ");
			params.add(status);
		} else {
			sql.append("AND status!=-1 ");
		}
		if(start != null) {
			sql.append("AND create_time>=? ");
			params.add(start);
		}
		if(end != null) {
			sql.append("AND create_time<=? ");
			params.add(end);
		}
		if(StrKit.isBlank(orderProp)) {
			orderProp = "update_time";
		}
		sql.append("ORDER BY ").append(orderProp).append(" ");
		if("descending".equals(orderType)) {
			sql.append("DESC ");
		}
		return Db.paginate(pageNum, pageSize, selectSql, sql.toString(), params.toArray());
	}

	public boolean changeStatus(Integer[] ids, int status) {
		Db.update("update b_product set status=? where id in (" + Common.arrayToSqlIn(ids) + ")", status);
		if(status != 1) {// 如果不为上架，则修改该商品下所有规格的状态
			ProductStandard.dao.changeStatus(ids, status);
		}
		return true;

	}
}
