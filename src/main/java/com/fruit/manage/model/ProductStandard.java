package com.fruit.manage.model;

import com.fruit.manage.model.base.BaseProductStandard;
import com.fruit.manage.util.Common;
import com.jfinal.plugin.activerecord.Db;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class ProductStandard extends BaseProductStandard<ProductStandard> {
	public static final ProductStandard dao = new ProductStandard().dao();

	public List<ProductStandard> list(int productId) {
		return find("SELECT * FROM b_product_standard WHERE product_id=?", productId);
	}

	public boolean changeStatus(Integer[] productIds, int status) {
		Db.update("update b_product_standard set status=? where product_id in (" + Common.arrayToSqlIn(productIds) + ") ", status);
		return true;
	}

	public boolean changeStatusOne(int standardId, int status) {
		Db.update("update b_product_standard set status=? where id=? ", status, standardId);
		return true;
	}
}
