package com.itheima.mybatis.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.itheima.mybatis.dao.UserMapper;
import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.utils.SqlSessionFactoryUtils;

public class MapperTest {

	/**
	 * 根据ID获取用户信息
	 * @throws IOException
	 */
	@Test
	public void findUserById() {
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从sqlSession中获取mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//执行sql语句
		User user = userMapper.findUserById(1);
		System.out.println(user);
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
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//执行sql语句
		List<User> list = userMapper.findUserByUserName("杨");
		for (User user : list) {
			System.out.println(user);
		}
		//释放资源
		sqlSession.close();
	}
}
