package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		//mybatis-config.xml 읽어드리기
		
		SqlSession sqlSession = null;
		
		//SqlSession생성하기 위해서는 -> SqlSessionFactory객체 필요
		//SqlSessionFactory생성하기위해서는 -> SqlSessionFactoryFactoryBuilder필요
		
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession(false); // true(자동커밋), false(수동커밋)
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
}
