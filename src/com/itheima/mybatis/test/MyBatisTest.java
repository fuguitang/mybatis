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
import com.itheima.mybatis.utils.SqlSessionFactoryUtils;

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
		User user = new User();
		user.setUsername("%王%");
		List<User> list = sqlSession.selectList("user.findByUsername", user);
		//输出结果
		for (User user2 : list) {
			System.out.println(user2);
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
		user.setUsername("赵子龙2");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("常山");
		sqlSession.insert("user.insertUser", user);
		System.out.println(user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
	
	/**
	 * 修改用户信息
	 * @throws IOException
	 */
	@Test
	public void updateUser() throws IOException {
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//创建核心配置文件的输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		//创建SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		//修改操作
		User user = new User();
		user.setId(26);
		user.setUsername("王某某");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("北京");
		session.update("user.updateUser", user);
		//提交事务
		session.commit();
		//释放资源
		session.close();
	}
	
	/**
	 * 删除用户信息
	 */
	@Test
	public void deleteUserById() {
		
		//创建SqlSessionFactory对象
		SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
		//创建SqlSession对象
		SqlSession sqlSession = factory.openSession();
		//执行删除操作
		User user = new User();
		user.setId(28);
		sqlSession.delete("user.deleteUserById", user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
}
