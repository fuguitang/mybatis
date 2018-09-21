package com.itheima.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * 根据用户ID查询用户信息
	 * @param id
	 * @return
	 */
	@Override
	public User findById(int id) {
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//接受结果
		User user = sqlSession.selectOne("user.findById", id);
		//释放资源
		sqlSession.close();
		return user;
	}

	/**
	 * 根据用户姓名查询用户信息
	 * @param username
	 * @return
	 */
	@Override
	public List<User> findByUsername(User user) {
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//接受结果
		List<User> list = sqlSession.selectList("user.findByUsername", user);
		//释放资源
		sqlSession.close();
		return list;
	}

	/**
	 * 新增用户信息
	 * @param user
	 */
	@Override
	public User insertUser(User user) {
		//创建SqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.insert("user.insertUser", user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		return user;
	}

	/**
	 * 修改用户信息
	 * @param user
	 */
	@Override
	public void updateUser(User user) {
		//创建SqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.update("user.updateUser", user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}

	/**
	 * 根据用户id删除用户信息
	 * @param id
	 */
	@Override
	public void deleteUserById(User user) {
		//创建SqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.delete("user.deleteUserById", user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}

}
