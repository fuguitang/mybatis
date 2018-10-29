package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.UserOrder;

public interface UserOrderMapper {
	
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	public List<UserOrder> findUserOrderByUserId();
	
	/**
	 * 根据username查询用户信息
	 * @param username
	 * @return
	 */
	public List<UserOrder> findUserByUserName(String username);

}
