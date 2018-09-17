package com.itheima.mybatis.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class MyBatisTest {
	
	/**
	 * 根据ID获取用户信息
	 * @throws IOException
	 */
	@Test
	public void findById() throws IOException {
		
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssdf = new SqlSessionFactoryBuilder();
		//创建核心配置文件的输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = ssdf.build(inputStream); 
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询
		User user = sqlSession.selectOne("user.findById", 1);
		//输出结果
		System.out.println(user);
		//释放资源
		sqlSession.close();
	}
	
	/**
	 * 根据用户姓名获取用户信息
	 * @throws IOException
	 */
	@Test
	public void findByUsername() throws IOException {
		
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssdf = new SqlSessionFactoryBuilder();
		//创建核心配置文件的输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = ssdf.build(inputStream); 
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询
		List<User> list = sqlSession.selectList("user.findByUsername", "王");
		//输出结果
		for (User user : list) {
			System.out.println(user);
		}
		//释放资源
		sqlSession.close();
	}
	
	/**
	 * 新增用户信息
	 * @throws IOException
	 */
	@Test
	public void insertUser() throws IOException {
		
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssdf = new SqlSessionFactoryBuilder();
		//创建核心配置文件的输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = ssdf.build(inputStream); 
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//插入用户信息
		User user = new User();
		user.setUsername("赵子龙");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("常山");
		sqlSession.insert("user.insertUser", user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
}
