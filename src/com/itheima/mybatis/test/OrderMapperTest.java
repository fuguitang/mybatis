package com.itheima.mybatis.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.itheima.mybatis.mapper.OrderUserMapper;
import com.itheima.mybatis.pojo.OrderUser;
import com.itheima.mybatis.utils.SqlSessionFactoryUtils;

public class OrderMapperTest {

	/**
	 * 根据ID获取用户信息
	 * @throws IOException
	 */
	@Test
	public void findUserOrderByOrderId() {
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从sqlSession中获取mapper接口的代理对象
		OrderUserMapper orderUserMapper = sqlSession.getMapper(OrderUserMapper.class);
		//执行sql语句
		OrderUser orderUser = orderUserMapper.findUserOrderByOrderId(1);
		System.out.println(orderUser);
		//释放资源
		sqlSession.close();
	}
	
	/**
	 * 根据username获取用户信息
	 */
	@Test
	public void findUserByUserName(){
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从sqlSession中获取mapper接口的代理对象
		OrderUserMapper orderUserMapper = sqlSession.getMapper(OrderUserMapper.class);
		//执行sql语句
		List<OrderUser> list = orderUserMapper.findUserOrderByUserName("王");
		for (OrderUser orderUser : list) {
			System.out.println(orderUser);
		}
		//释放资源
		sqlSession.close();
	}
}
