package com.appserver.user;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {

	public static final User dao = new User();

	/**
	 * 获取用户列表
	 * @return
	 */
	public List<User> getAllUser() {
		return User.dao.find("select * from user");
	}

	/**
	 * 添加用户
	 * @param name 用户名
	 * @return
	 */
	public User addUser(String name) {
		User user = new User();
		user.set("name", name);
		user.save();
		return findUser(name);
	}
	
	
	/**
	 * 查找用户
	 * @param name 用户名
	 * @return
	 */
	public User findUser(String name) {
		return User.dao.findFirst("select * from user where name='" + name+"'");
	}
}
