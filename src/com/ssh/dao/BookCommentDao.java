package com.ssh.dao;

import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.ssh.model.BookComment;

public class BookCommentDao {
	SessionFactory sessionFactory;
	
	public BookCommentDao(){}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 通过图书编号,当前评论页码，每页最大评论条数获取该图书对应页码的点评列表
	 * @param bookId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<BookComment> getBookCommentByBookIdAndPageNo(int bookId, int pageNo, int pageSize){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from BookComment where bookId=?";  //数据库预编译查询语句
			Query query=session.createQuery(queryString);
			query.setParameter(0, bookId);
			
			query.setFirstResult((pageNo-1)*pageSize); //设置当前页码显示的第一条记录的索引
			query.setMaxResults(pageSize); //这一页显示的记录个数
			
			List<BookComment> list = query.list();
			
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	/**
	 * 通过图书编号获取该图书的所有点评
	 * @param bookId
	 * @return
	 */
	public List<BookComment> getAllBookCommentByBookId(int bookId){
		Session session=null;
		try{
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from BookComment where bookId=?";   //数据库预编译查询语句
			Query query=session.createQuery(queryString);
			query.setParameter(0, bookId);  //设置参数
			
			List<BookComment> list = query.list();
			
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	/**
	 * 将传入的图书评论添加至数据库
	 * @param bookComment
	 * @return
	 */
	public int setBookComment(BookComment bookComment){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			//开启事务
			Transaction trans=session.beginTransaction();
			//保存数据，返回受影响的行数
			int num=Integer.parseInt(session.save(bookComment).toString()); //存到缓冲区里,并未真正写入数据库
			//提交事物
			trans.commit();
			return num;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	/**
	 * 根据传入的图书编号删除对应图书的所有书评
	 * @param bookId
	 * @return
	 */
	public boolean deleteAllBookCommentByBookId(int bookId){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			
			List<BookComment> list = this.getAllBookCommentByBookId(bookId);  //获取该图书的所有书评
			//开启事务
			Transaction trans=session.beginTransaction();
			for(int i = 0; i < list.size(); i++){  //逐个删除书评
				list.get(i).setFlag(1); //将书评的删除标记设置为已删除
				session.update(list.get(i)); //更新书评状态
			}
			//提交事物
			trans.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
}
