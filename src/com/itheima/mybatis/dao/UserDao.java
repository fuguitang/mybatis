package com.itheima.mybatis.dao;

import java.util.List;

import com.itheima.mybatis.pojo.User;

public interface UserDao {
	
	/**
	 * 根据用户ID查询用户信息
	 * @param id
	 * @return
	 */
	public User findById(int id);
	
	/**
	 * 根据用户姓名查询用户信息
	 * @param username
	 * @return
	 */
	public List<User> findByUsername(User user);
	
	/**
	 * 新增用户信息
	 * @param user
	 */
	public User insertUser(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 根据用户id删除用户信息
	 * @param id
	 */
	public void deleteUserById(User user);

}
