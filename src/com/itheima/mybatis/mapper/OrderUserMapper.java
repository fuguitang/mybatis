package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.OrderUser;

public interface OrderUserMapper {
	
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	public OrderUser findUserOrderByOrderId(int id);
	
	/**
	 * 根据username查询用户信息
	 * @param username
	 * @return
	 */
	public List<OrderUser> findUserOrderByUserName(String username);

}
