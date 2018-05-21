package com.yidu.mybatis.example.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yidu.mybatis.example.bean.User;

public class MyBatisTest {
	
	public static void main(String[] args) {
		//findUserById(1001);
		//deleteUser(2003);
		//insertUser(new User(1006, "zhuqi", "zq", new Date(), "F", "湖南省长沙市开福区"));
		//updateUser(new User(1006, "lianghang", "lh", new Date(), "F", "湖南省长沙市"));
		//findUserByName("li");
		insertUser();
		
		
	}
	
	public static SqlSession getSqlSession() throws IOException{
		//
		String resource = "res/config/SqlMapConfig.xml";
		//将资源文件转化为字节流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//利用SqlSessionFactoryBuilder对象创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//利用SqlSessionFactroy(会话工厂)创建sqlSeesion
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	public static void findUserById(int id){
		try {
			//拿到会话对象
			SqlSession sqlSession = getSqlSession();
			
			/*  selectOne(String statement, Object parameter)
			 *  statement是MapStatement的id值
			 *  parameter是输入参数
			 */
			User user = sqlSession.selectOne("findUserById", id);
			
			System.out.println(user);
			
			sqlSession.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void findUserByName(String username){
		try {
			//拿到会话对象
			SqlSession sqlSession = getSqlSession();
			
			List<User> users = sqlSession.selectList("findUserByName", username);
			
			System.out.println(users);
			
			sqlSession.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(int id){
		try {
			//拿到会话对象
			SqlSession sqlSession = getSqlSession();
			//删除用户
			sqlSession.delete("deleteUser", id);
			//提交事务
			sqlSession.commit();
			//关闭会话
			sqlSession.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param user
	 */
	public static void insertUser(User user){
		try {
			//拿到会话对象
			SqlSession sqlSession = getSqlSession();
			//添加用户
			sqlSession.insert("insertUser", user);
			//提交事务
			sqlSession.commit();
			//关闭会话
			sqlSession.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertUser(){
		try {
			//拿到会话对象
			SqlSession sqlSession = getSqlSession();
			//添加用户
			User user = new User();
			user.setUsername("xiaoming");
			user.setAddress("湖南岳阳");
			user.setPassword("xm");
			user.setBirthday(new Date());
			user.setGender("F");
			sqlSession.insert("insertUser", user);
			
			System.out.println(user.getUserid());
			//提交事务
			sqlSession.commit();
			//关闭会话
			sqlSession.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void updateUser(User user){
		try {
			//拿到会话对象
			SqlSession sqlSession = getSqlSession();
			//修改用户  user.getUserid() user
			//先获得要修改的用户，在利用set方法修改属性值，然后调用update方法修改
			sqlSession.update("updateUser", user);
			//提交事务
			sqlSession.commit();
			//关闭会话
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
