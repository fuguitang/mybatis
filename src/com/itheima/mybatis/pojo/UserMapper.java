package com.itheima.mybatis.pojo;

import java.util.List;

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
