package com.fruit.manage.base;

import com.fruit.manage.controller.*;
import com.fruit.manage.controller.login.LoginController;
import com.fruit.manage.controller.order.OrderController;
import com.fruit.manage.controller.user.RolesController;
import com.fruit.manage.controller.user.UserController;
import com.jfinal.config.Routes;

/**
 * 路由规则注册
 * 控制用户请求转到具体action
 */
public class BaseRoutesConfig extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class);
		add("/product", ProductController.class);
		add("/productStandard", ProductStandardController.class);
		add("/productMarket", ProductMarketController.class);
		add("/login", LoginController.class);

		add("/manage/order", OrderController.class);
		add("/manage/common", CommonController.class);
		add("/manage/banner", BannerController.class);
		add("/manage/type", TypeController.class);
		add("/manage/typeGroup", TypeGroupController.class);
		add("/manage/role", RolesController.class);
		add("/manage/user", UserController.class);
		add("/manage/test", TestController.class);
	}

}
