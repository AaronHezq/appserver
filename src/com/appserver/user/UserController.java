package com.appserver.user;

import java.util.List;

import com.appserver.model.RequestModel;
import com.jfinal.core.Controller;

public class UserController extends Controller {

	
	/**
	 * 获取用户列表
	 */
	public void getUsers() {
		UserDate userDate = new UserDate();
		List<User> users = User.dao.getAllUser();
		userDate.setUsers(users);
		renderJson(new RequestModel(1, "success", userDate));
	}

	/**
	 * 添加用户
	 */
	public void addUser() {
		String name = getPara("name");
		if (name == null || name.equals("")) {
			renderJson(new RequestModel(0, "缺少必要参数", null));
		} else {
			if (User.dao.findUser(name) != null) {
				renderJson(new RequestModel(0, "用户已存在", null));
			} else {
				User user = User.dao.addUser(name);
				if (user != null) {
					renderJson(new RequestModel(1, "添加成功", user));
				} else {
					renderJson(new RequestModel(0, "添加失败", null));
				}
			}
		}
	}

}