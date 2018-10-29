package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.User;

public interface UserMapper {
	
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
	
	/**
	 * 根据username查询用户信息
	 * @param username
	 * @return
	 */
	public List<User> findUserByUserName(String username);

}
