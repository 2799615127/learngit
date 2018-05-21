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
		//insertUser(new User(1006, "zhuqi", "zq", new Date(), "F", "����ʡ��ɳ�п�����"));
		//updateUser(new User(1006, "lianghang", "lh", new Date(), "F", "����ʡ��ɳ��"));
		//findUserByName("li");
		insertUser();
		
		
	}
	
	public static SqlSession getSqlSession() throws IOException{
		//
		String resource = "res/config/SqlMapConfig.xml";
		//����Դ�ļ�ת��Ϊ�ֽ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//����SqlSessionFactoryBuilder���󴴽��Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//����SqlSessionFactroy(�Ự����)����sqlSeesion
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	public static void findUserById(int id){
		try {
			//�õ��Ự����
			SqlSession sqlSession = getSqlSession();
			
			/*  selectOne(String statement, Object parameter)
			 *  statement��MapStatement��idֵ
			 *  parameter���������
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
			//�õ��Ự����
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
			//�õ��Ự����
			SqlSession sqlSession = getSqlSession();
			//ɾ���û�
			sqlSession.delete("deleteUser", id);
			//�ύ����
			sqlSession.commit();
			//�رջỰ
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
			//�õ��Ự����
			SqlSession sqlSession = getSqlSession();
			//����û�
			sqlSession.insert("insertUser", user);
			//�ύ����
			sqlSession.commit();
			//�رջỰ
			sqlSession.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertUser(){
		try {
			//�õ��Ự����
			SqlSession sqlSession = getSqlSession();
			//����û�
			User user = new User();
			user.setUsername("xiaoming");
			user.setAddress("��������");
			user.setPassword("xm");
			user.setBirthday(new Date());
			user.setGender("F");
			sqlSession.insert("insertUser", user);
			
			System.out.println(user.getUserid());
			//�ύ����
			sqlSession.commit();
			//�رջỰ
			sqlSession.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void updateUser(User user){
		try {
			//�õ��Ự����
			SqlSession sqlSession = getSqlSession();
			//�޸��û�  user.getUserid() user
			//�Ȼ��Ҫ�޸ĵ��û���������set�����޸�����ֵ��Ȼ�����update�����޸�
			sqlSession.update("updateUser", user);
			//�ύ����
			sqlSession.commit();
			//�رջỰ
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
