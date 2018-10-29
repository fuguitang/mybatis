package com.itheima.mybatis.utils;

import java.io.IOException;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class SqlSessionFactoryUtils{
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			//创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//创建核心配置文件的输入流
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//创建SqlSessionFactory对象
			sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
