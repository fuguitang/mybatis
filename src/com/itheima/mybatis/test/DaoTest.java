package com.itheima.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.impl.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

public class DaoTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception {
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssdf = new SqlSessionFactoryBuilder();
		//创建核心配置文件的输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory对象
		this.sqlSessionFactory = ssdf.build(inputStream); 
	}
	
	 /**
	 * 根据用户ID查询用户信息
	 * @param id
	 * @return
	 */
	@Test
	public void findUserById() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		User user = userDao.findById(10);
		System.out.println(user);
	}
	
	/**
	 * 根据用户姓名查询用户信息
	 * @param username
	 * @return
	 */
	@Test
	public void findByUsername() {
		User user = new User();
		user.setUsername("王");
		user.setSex("女");
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.findByUsername(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
		
	}
	
	/**
	 * 新增用户信息
	 * @param user
	 */
	@Test
	public void insertUser() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("杨妍");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("中国");
		User user2 = userDao.insertUser(user);
		System.out.println(user2);
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	@Test
	public void updateUser() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setId(10);
		user.setUsername("张三疯");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("中国");
		userDao.updateUser(user);
		User user2 = userDao.findById(10);
		System.out.println(user2);
	}
	
	/**
	 * 根据用户id删除用户信息
	 * @param id
	 */
	@Test
	public void delete() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setId(35);
		userDao.deleteUserById(user);
	}
}
