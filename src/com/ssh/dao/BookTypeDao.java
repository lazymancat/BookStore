package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ssh.model.BookType;

public class BookTypeDao {
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void BookTypeDao(){}
	
	public List<BookType> getAllBookType(){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			//HQL语句
			String queryString="from BookType Where flag=0"; //Like '%" + bookType + "%'
			//得到Query对象
			Query query=session.createQuery(queryString);
			//执行查询HQL语句
			List<BookType> list=(List<BookType>)query.list();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
		
	}
	
	//添加新的分类
	public void addBookType(BookType bookType){
		Session session=null;
		try{
		//获得session
		session=sessionFactory.openSession();
		//打开一个事物
		Transaction trans=session.beginTransaction();
		//保存数据，返回受影响的行数
		session.save(bookType);//存到缓冲区里,并未真正写入数据库
		//提交事物
		trans.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			//关闭session
			session.close();
		}
		
	}
	
	//删除图书分类
	public boolean deleteBookType(int typeId){
		System.out.println("这里是deleteBookById开头");
		Session session=null;
		boolean flag = true;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			BookType booktype=(BookType)session.load(BookType.class,typeId);
			booktype.setFlag(1);
			Transaction trans=session.beginTransaction();
			session.update(booktype);
			trans.commit();
			return flag;
		}catch(Exception ex){
			System.out.println("这里是deleteBookById错误!");
			flag = false;
			ex.printStackTrace();
			return flag;
		}finally{
			//关闭session
			session.close();
		}	
	}
	
	public boolean reviseBookType(BookType bookType){
		//临时状态
		System.out.println("这里是ReviseBookType开头");
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			//SQL语句
			Transaction trans=session.beginTransaction();
			session.update(bookType);
			trans.commit();
			System.out.println("这里是ReviseBookType结尾");
			return true;
		}catch(Exception ex){
			System.out.println("这里ReviseBookType是错误!");
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}

}
