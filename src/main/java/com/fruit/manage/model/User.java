package com.fruit.manage.model;

import com.fruit.manage.model.base.BaseUser;
import com.fruit.manage.util.Common;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User().dao();
	
	/**
	 * 根据用户登录名+密码查询用户（用于验证登录）
	 * @param userName 非空
	 * @param password	非空
	 * @return
	 */
	public User getUser(String userName, String password){
		if(StringUtils.isAllBlank(userName, password)){
			return null;
		}
		return dao.findFirst("select * from a_user where name = ? and pass = ?", userName, password);
	}
	
	/**
	 * 根据用户登录名查询用户
	 * @param userName 非空
	 * @return
	 */
	public User getUser(String userName){
		if(StringUtils.isBlank(userName)){
			return null;
		}
		return dao.findFirst("select * from a_user where name = ?", userName);
	}
	
	/**
	 * 分页查询用户列表
	 * @param userName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<User> getData(String userName, int pageNum, int pageSize, String orderBy, boolean isASC) {
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("from a_user where 1=1 ");
		if(StrKit.notBlank(userName)){
			sql.append("and name like ? ");
			params.add("%" + userName + "%");
		}
		orderBy = StrKit.isBlank(orderBy)?"create_time":orderBy;
		sql.append("order by "+orderBy+" "+(isASC?"":"desc "));
		return paginate(pageNum, pageSize, "select * ", sql.toString(), params.toArray());
	}

	/**
	 * 保存用户（如果关联的角色不为空，会同时保存关联的角色）
	 * @param model
	 * @param roleIds
	 */
	public boolean save(User model, String[] roleIds) {
		return Db.tx(new IAtom() {
			@Override
			public boolean run() throws SQLException {
				if(model.getId() == null){
					model.setCreateTime(new Date());
				}
				model.setUpdateTime(new Date());
				if(model.getId() == null){
					model.save();//保存用户
				}else{
					model.update();//更新用户
				}
				Db.update("delete from a_user_role where user_id = ?", model.getId());
				if(roleIds != null && roleIds.length > 0){
					List<Object[]> params = new ArrayList<>();
					for(String roleId : roleIds) {
						params.add(new Object[]{model.getId(), roleId});
					}
					String sql = "insert into a_user_role(user_id, role_id) values(?,?)";
					Db.batch(sql, Common.listTo2Array(params), params.size());
				}
				return true;
			}
		});
	}
}
