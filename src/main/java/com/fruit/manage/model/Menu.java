package com.fruit.manage.model;

import java.util.List;

import com.fruit.manage.model.base.BaseMenu;
import com.jfinal.plugin.activerecord.Db;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Menu extends BaseMenu<Menu> {
	public static final Menu dao = new Menu().dao();

	/**
	 * 根据角色id查询对应的菜单id列表
	 * @param roleId
	 * @return
	 */
	public List<Integer> getMenuIdsByRoleId(int roleId) {
		return Db.query("SELECT p.id FROM `a_role` r, `a_role_menu` rp, `a_menu` p WHERE r.`id` = rp.`role_id` AND p.`id` = rp.`menu_id` AND r.`id` = ?", roleId);
	}
}